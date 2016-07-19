# MyShell
Java implementation of a shell gievn in a task

Available commands:

`prompt [value]` - changes presented prompt to given value

Possible values of a `prompt` parameter:

`$cwd` - displays a path to current working directory in a prompt

`reset` - resets a prompt to default value

`[user's value]` - displays a user defined prompt

Other commands:

`dir` - presents contents of working directory

`cd [subfolder name]` - navigates to selected subdirectory of the current directory

`cd ..` - navigates to parent directory of the current directory

`tree` - displays a current working directory tree along with all of it's subdirectories

`exit` - exits the shell

=========

To generate a jar file of this project using maven:
  1. after cloning the project, open terminal in the project's main directory and type:

  `mvn package`
  
  2. Next go to generated `target` directory:
  
  `cd target`
  
  3. To run generated jar file enter:
  
  `java -jar MyShell.jar`