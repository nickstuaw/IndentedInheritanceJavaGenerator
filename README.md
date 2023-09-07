A program which is given a list in markdown with indents.
It generates classes using the indentation to signify the inheritance of each class.
Each indentation is signified by two spaces ("  ") after a * or - character.
Categorise lines starting with * and - separately or add a boolean representing which character was used.
Maybe an enum called LineType
hashtag at the start = HEADING
asterisk at the start = ASTERISK
hyphen at the start = HYPHEN
Indentation should be shown as an int called indentationLevel
