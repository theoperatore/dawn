---
layout: page
title: "Utilities"
---

A static class holding static fields for formatting output to the terminal/console window.

This class also has methods that involve the handling of loading and saving games.

Printing to the console should always be done with this class, even if the System console isn't used, a different PrintStream can be specified making printing relatively easy to any GUI.

package: [core]({{ site.baseurl }}/core/);
    
## Contents

- [Fields](#fields)
- [Methods](#methods)
  - [println(String message)](#static-void-printlnstring-message)
  - [println(String color, String message)](#static-void-printlnstring-color-string-message)
  - [print(String message)](#static-void-printstring-message)
  - [print(String color, String message)](#static-void-printstring-color-string-message)
  - [printPrompt(String prompt)](#static-void-printpromptstring-prompt)
  - [setOutputStream(PrintStream o)](#static-void-setoutputstreamprintstream-o)


# Fields

Static final String variables that help with color output and console control

{%highlight java%}
Utilities.DEFAULT
Utilities.BLACK  
Utilities.RED    
Utilities.GREEN  
Utilities.YELLOW 
Utilities.BLUE   
Utilities.MAGENTA
Utilities.CYAN   
Utilities.WHITE  

Utilities.BOLD_BLACK  
Utilities.BOLD_RED    
Utilities.BOLD_GREEN  
Utilities.BOLD_YELLOW 
Utilities.BOLD_BLUE   
Utilities.BOLD_MAGENTA
Utilities.BOLD_CYAN   
Utilities.BOLD_WHITE  

Utilities.UNDERLINE_BLACK  
Utilities.UNDERLINE_RED    
Utilities.UNDERLINE_GREEN  
Utilities.UNDERLINE_YELLOW 
Utilities.UNDERLINE_BLUE   
Utilities.UNDERLINE_MAGENTA
Utilities.UNDERLINE_CYAN   
Utilities.UNDERLINE_WHITE  

Utilities.MOVE_TO_BOTTOM
Utilities.CLEAR_SCREEN  
{%endhighlight%}

# Methods

#### static void println(String message)

Prints the `message` to the console, then sets the cursor to the next line.

#### static void println(String color, String message)

Prints the `message` in the specified `color`, then sets the cursor to the next line.

see [Fields](#fields) for color options.

i.e:

{%highlight java%}
//prints 'Hello, World' in bold yellow
Utilities.println(Utilities.BOLD_YELLOW, "Hello, World");
{%endhighlight%}

#### static void print(String message)

Prints the `message` to the console.

#### static void print(String color, String message)

Prints the `message` in the specified `color`. 

see [Fields](#fields) for color options.

#### static void printPrompt(String prompt)

Prints a newline character and then the `prompt` parameter followed by a space.

#### static void setOutputStream(PrintStream o)

Set to which stream the other methods should print.