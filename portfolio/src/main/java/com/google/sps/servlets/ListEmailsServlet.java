
package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.gson.Gson;
import com.google.sps.data.Email;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing emails. */
@WebServlet("/list-emails")
public class ListEmailsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Email").build();

    // Gets all enitites with kind "Email"
    QueryResults<Entity> emailQuery = datastore.run(query);

    List<Email> emails = new ArrayList<>();

    // Load each email into emails ArrayList
    while (emailQuery.hasNext()) {
      Entity emailEntity = emailQuery.next();

      long key = emailEntity.getKey().getId();
      String email = emailEntity.getString("email");

      Email task = new Email(key, email);
      emails.add(task);
    }

    Gson gson = new Gson();

    // Email entity list -> JSON 
    response.setContentType("application/json");
    response.getWriter().println(gson.toJson(emails));
  }
}