# Notitiyas.java
Notes app using SQLite implementing CRUD.

It is a simple app for storing notes in the internal Android database SQLite.

First screen shows the name of the app, after 2 seconds jumps to the List of notes you have already saved.
In the topbar you can delete create a new note or delete all.

If you create a note, the first field cannot be empty, and the second field must be a number (I want to make it a DATE field).

The listview shows all the notes, by clicking on any of them it takes you to another activity where you can see the content of the note, and delete the note.

Back to the listview, if you holdpress a note, you can edit the content of the note.
