# UNISSA

## Identification of the Design Problem
### The part(s) of UML diagrams of the existing design where the design problem is detected.
![Image description](https://github.com/jrdalino/unissa/blob/master/images/uml-before.png)
### The cause(s) for redesign.
- Persistent Class which converts Objects to CSV and vice versa is tightly coupled to the other parts of the program. Supporting new persistence destinations (RDBS, XML, etc) is not trivial.
### The aspect(s) that should be flexibly varied in the new design.
![Image description](https://github.com/jrdalino/unissa/blob/master/images/uml-after.png)

## Presentation
### Brief description of the design problem
- When the persistence storage mechanism (e.g. file-based, RDBMS, XML database) is changed from one to another (e.g. from file-based to RDBMS), the business objects (entities) that need to be persisted, will also have to change. 
- How can we reduce the effort required to move the implementation mechanism of persisting from one to the other?

### Candidate design patterns considered
- Adapter Pattern

### Motivation to choose a pattern(s)
- Design should follow Single Responsibility Principle. Separate the interface or data conversion code from the primary business logic of the program.
- Design should follow Open/Closed Principle. Introduce new types of adapters into the program without breaking the existing client code, as long as they work with the adapters through the client interface.

### Structure of the pattern (you should map the participants to your applications classes/objects)
- Client -> Inventory
- Target -> StorageInterface
- Adapter -> CSVAdapter & XMLAdapter
- Adaptee -> CSVAdaptee & XMLAdaptee

### Collaborations among the participants (specific to your application objects)
- To follow

### Implementation decisions that you have taken
- Step 1: Created the Main Class which simulates "ManageInventoryControl" and calls the Inventory store() and load() methods.
- Step 2: Created the Category Class to hold the Category object.
- Step 3: Created the "Client": Inventory Class that contains the load and store methods and communicates with the Target.
- Step 4: Created the "Target": StorageInterface which is the existing interface clients communicate with.
- Step 5: Created the "Adapters" CsvAdapter and XmlAdapter which implements StorageInterface and adapts the Adaptee to the Target.
- Step 6: Created the "Adaptees" CsvAdaptee and XmlAdaptee which contains the openFile(), writeLine(), readLine() and closeFile() methods.

## Execution Output
```
Saving to CSV
Saving to XML
[]
Category A - CSV
Category B - CSV
Category C - CSV
[]
Category A - XML
Category B - XML
Category C - XML
```

## References
- To follow