package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that responds with "hello world" */
@WebServlet("/string")
public class StringServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> msgs = new ArrayList<>();
    msgs.add("x");
    msgs.add("y");
    msgs.add("z");

    Gson gson = new Gson();
    String json = gson.toJson(msgs);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  
}
