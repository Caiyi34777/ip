
# User Guide - Duke

## Features 

### Add 
Add a new task (of type todo/event/deadline) to the task list.

### List
View the whole task list.

### Set as done
Set a task in the list as done by list index.

### Delete
Delete a task in the list by list index.

### Find
Find tasks with a exact keyword.

### Save
Save the task list and load with saved data when reopening.

## Usage

#### `todo` - add a todo task
Example of usage: 

`todo homework`



Expected outcome:

      _____________________________________________
       Got it. I've added this task:
         [T][✘] homework
       Now you have 1 task(s) in the list.
      _____________________________________________

#### `event /at yyyy-mm-dd` - add an event task
Example of usage: 

`event concert /at 2020-05-01`

Expected outcome:

     _____________________________________________
      Got it. I've added this task:
        [E][✘] concert (at: May 1 2020)
      Now you have 2 task(s) in the list.
     _____________________________________________
     
#### `deadline /by yyyy-mm-dd` - add a deadline task
Example of usage: 

`deadline assignmet /by 2020-09-23`

Expected outcome:

     _____________________________________________
      Got it. I've added this task:
        [D][✘] assignmet (by: Sep 23 2020)
      Now you have 3 task(s) in the list.
     _____________________________________________
     
#### `list` - list out the task list
Example of usage: 

`list`

Expected outcome:

     _____________________________________________
      Here are the task(s) in your list:
      1.[T][✘] homework
      2.[E][✘] concert (at: May 1 2020)
      3.[D][✘] assignmet (by: Sep 23 2020)
     _____________________________________________      

#### `done` - set a task as done
Example of usage: 

`done 1`

Expected outcome:

     _____________________________________________
      Nice! I've marked this task as done:
        [T][✓] homework
     _____________________________________________
     
#### `delete` - delete a task in the list
Example of usage: 

`delete 1`

Expected outcome:

    _____________________________________________
      Noted. I've removed this task:
        [T][✓] homework
      Now you have 2 task(s) in the list.
    _____________________________________________
    
#### `find` - find task by an exact keyword
Example of usage: 

`find concert`

Expected outcome:

     _____________________________________________
     Here are the matching task(s) in your list:
      1.[E][✘] concert (at: May 1 2020)
     _____________________________________________
    
#### `bye` - finish duke and save the task list
Example of usage: 

`bye`

Expected outcome:

     _____________________________________________
      Bye. Hope to see you again soon!
     _____________________________________________    
