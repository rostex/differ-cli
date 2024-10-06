## Difference calculator
A difference calculator is a program that identifies discrepancies between two data structures. This task is quite common, and there are many online services available to solve it. Such a mechanism is often used for test analysis or for automatically monitoring changes in configuration files.
### Status:
[![Actions Status](https://github.com/rostex/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/rostex/java-project-71/actions)
[![Java CI](https://github.com/rostex/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/rostex/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/a37d42bcea0a13c941f5/maintainability)](https://codeclimate.com/github/rostex/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a37d42bcea0a13c941f5/test_coverage)](https://codeclimate.com/github/rostex/java-project-71/test_coverage)


### Usage example: 
```
# format plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# format stylish
./app file1.json file2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```

### Demonstrarion:

Get differences from json files:
[![asciicast](https://asciinema.org/a/aHsZxybb8jw7prU7LRgzqOyuP.svg)](https://asciinema.org/a/aHsZxybb8jw7prU7LRgzqOyuP)

Get differences from yaml files:
[![asciicast](https://asciinema.org/a/Di356sZ4owpa4nODeOhCKlch7.svg)](https://asciinema.org/a/Di356sZ4owpa4nODeOhCKlch7)



