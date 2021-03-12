// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I spend a lot of time on YouTube.', 'I am watching 3 different anime shows right now.', 
      'They are Jujutsu Kaisen, Attack on Titan, and The Seven Deadly Sins.', 'I like Jujutsu Kaisen the best at the moment.'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

/** Fetches random element from the server list data and adds it to the page. */
async function fetchRandom() {
  const responseFromServer = await fetch('/string');
  const msgs = await responseFromServer.json();

  const randomMsg = msgs[Math.floor(Math.random() * msgs.length)];

  const stringContainer = document.getElementById('string-container');
  stringContainer.innerText = randomMsg;
}

/** Loads user input emails and displays them on page */
async function loadEmails() {
    fetch('/list-emails').then(response => response.json()).then((emails) => {
    const emailListElement = document.getElementById("email-list");
    emails.forEach((email) => {
      emailListElement.appendChild(createEmailElement(email));
    })
  });
}

/** Creates an element that represents an email */
function createEmailElement(entity) {
  const emailElement = document.createElement('li');
  
  const titleElement = document.createElement('span');
  titleElement.innerText = entity.email;

  emailElement.appendChild(titleElement);
  return emailElement;
}