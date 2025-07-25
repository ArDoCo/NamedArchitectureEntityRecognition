# Teammates 2021

The text was taken from https://teammates.github.io/teammates/design.html

## Text Adaptation

Since the documentation contains many listings and implicit semantics, we slightly adapted the text.
Thereby, the text became more readable and easier to understand.

### Comprehension of changes:

* Images were removed
* Enlistings were removed
* In the description of the main components the component names in front of the colons were removed.
* "Notes:" or "Things to note:" were translated in: "There are some things to note."
* Sections and titles were removed
* Enumerations were replaced with their textual representation.
* "Example:" was replaced with "For example, "
* For listings introduced with a sentence including "the following [...] :" this was replaced with a list of the objects
  of the list. Additionally, the subject of the sentence was made explicit if necessary.
* "Package overview:" was replaced by "Package overview contains [...]" and a list of the packages.
* "Represented by these classes:" was replaced by "<Subject> is represented by the classes"
* "General: " was built in the text as introduction to the next sentence "In general, "
* "Access control: ", "API for creating entities:", "API for retrieving entitites:", "API for updating entities:", and "
  API for deleting entities:" were replaced by "To API for <use case> the following information are presented."
* "handles these:", "these:"  were replaced by "the following."
* If packages began with a dot, an x was inserted before
* Tables like, "Normal: |---------acceptance tests----|---system tests----|-----integration tests-----|------unit
  tests---------| TEAMMATES: |---------manual testing-------------| ----automated UI tests----|---automated component
  tests---|" were removed.
* Sentences were added at the end of sentences, where necessary.
* Dots that should be commas (esp. in ".e.g., <...>") were replaced.
* quotation marks were removed.
* Stars were removed
* { were removed
* At "Protecting persistable objects:" the colon was replaced with a comma
* At "Note:" in floating text, the next sentence was introduced with "Note that [...]"
* If it would not lead to a semantic change, colons in sentences were removed. Otherwise there were replaced by "are"/ "
  is"/ "is that"/ ...
* In case of "##TestDriver This component [..]", the "This" was replaced with "The TestDriver".

## License

The documentation of TEAMMATES is part of their [repository](https://github.com/TEAMMATES/teammates).
Therefore, the text we extracted from their documentation is licensed according to
the [license of TEAMMATES](https://github.com/TEAMMATES/teammates/blob/master/LICENSE) under GPL-2.0.