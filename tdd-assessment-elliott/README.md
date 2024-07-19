```yaml
name: Elliott Steer
date: 19 July 2024
```

# Object Oriented Development Week 2 Assessment – TDD Code

This repository contains my submission for the Test Driven Development (TDD) assessment, and demonstrates the use of the [JUnit](https://junit.org/junit5/) and [Mockito](https://site.mockito.org/) libraries to implement unit tests for the code.

The unit tests achieve code coverage of 94.9% of the project, according to Eclipse IDE analysis as of the most recent code commit.

Implementation of the TDD approach is documented via the commit history of this repository in line with the following methodology:

1) Write the test.
1) Make the test compile.
1) Watch the test fail.
1) Write the minimum code necessary to pass the test.
1) Refactor and generalise the code.

The **Act-Arrange-Assert** pattern is applied for the individual unit tests.

## Contents

- [Installation](#installation)
- [Assessment](#assessment)
- [Marking Scheme](#marking-scheme)
- [Documentation](#documentation)
  - [GradeCalculatorService](#gradecalculatorservice)
    - [Grade boundaries](#grade-boundaries)
    - [Notes on GradeCalculatorService specifications](#notes-on-gradecalculatorservice-specifications)
  - [GroupControllerService](#groupcontrollerservice)

## Installation

To clone this repo, open the terminal on your machine and run the following command from within the desired workspace:

```console
$ git clone https://git.fdmgroup.com/elliott.steer/tdd-assessment-elliott.git
```

Import the cloned repo into the Eclipse IDE as a `Maven` project.

## Assessment

Trainees have 5 hours to use TDD to write appropriate tests and the implementing code to meet the below requirements. **The implementing classes must implement the appropriate service interface provided**.

Trainees are provided with two interface files: 

- `GradeCalculatorService`

  - You should create a class which implements this interface. To be successful, the method in the implementing class must return the appropriate `String` value when a `double` representing a mark is passed in. They are as follows:
    - “fail” when less than 75.
    - “pass” when greater than or equal to 75 but less than 80.
    - “merit” when greater than or equal to 80 but less than 90.
    - “distinction” when greater than or equal to 90 but less than or equal to 100.

- `GroupControllerService`
  - You should create a class which implements this interface. To be successful, the methods in the implementing class must meet the requirements specified below (you will require some mock objects to fully test):
    - The `getAllTrainees()` method should return the `Map` of type `<String,Trainee>` returned by the `readGroup()` method of the `DatabaseReader` class (you should use the class provided and do not need to implement the database reader’s methods).
    - The `removeTraineeByUsername()` method should pass the trainee to be removed to the `deleteTraineeByUsername()` method of the `DatabaseWriter` class (you should use the class provided and do not need to implement the database writer’s methods).
    - The `addTrainee()` method should pass the trainee to be added to the `DatabaseWriter`’s `addTrainee()` method (you should use the class provided and do not need to implement the database writer’s methods).

## Marking Scheme

| Grade | Description |
| --- | --- |
| Fail | Unable to meet either of the `Service` requirements. |
| Pass | A `GradeCalculatorService` implementation returns the correct values and there are passing `JUnit` tests that prove this. |
| Merit | A `GroupControllerService` implementation has the correct behaviour and there are passing `JUnit` tests that prove this. |
| Distinction | `GroupControllerService` and `GradeCalculatorService` both have implementations that have the correct behaviour with passing tests that prove this using both `Mockito` and `JUnit` tests where appropriate. |

## Documentation

To run the tests for this project after importing it into an IDE (see [Installation](#installation)) open either the `GradeCalculatorTest.java` or `GroupControllerTest.java` and run the files.

Details of the tests conducted within each of those classes are provided below.

### GradeCalculatorService

The `GradeCalculatorService` interface is implemented via the `GradeCalculator` class located at `src/main/java/com/fdmgroup/tdd/gradecalculator/GradeCalculator.java`.

Tests for this implementation are provided under the `GradeCalculatorTest.java` file located at `src/test/java/com/fdmgroup/tdd/gradecalculator/`.

The unit tests for this section of the assignment make use of [`JUnit 5`](https://junit.org/junit5/).

There are 11 tests in total. Collectively, the tests verify that the `GradeCalculator` class:
- can initialise correctly; 
- implements all methods of the `GradeCalculatorService` interface;
- and returns the expected grade classification for marks that fall within each of the bounds designated within the [Assessment](#assessment) section of this document.

#### Grade boundaries

In addition to the test cases, a demonstration of the `GradeCalculator` implementation for grades that span the specified classifications is included under the `Runner` file located inside `src/main/java/com/fdmgroup/gradecalculator/`.

Grade classifications have been hard-coded according to the [Assessment](#assessment) specifications.

If needed, these boundaries may be adjusted by changing the private attributes in the constructor of the `GradeCalculator` class:

```java
// GradeCalculator.java
// ...preceding code
public GradeCalculator() {
	this.passThreshold = 75.0;
	this.meritThreshold = 80.0;
	this.distinctionThreshold = 90.0;
	this.validMarkLimit = 100.0;
}
// code continues...
```

...and the respective grade threshold values in the of the `GradeCalculatorTest` class:

```java
// GradeCalculatorTest.java
// ...preceding code
public class GradeCalculatorTest {
	
    GradeCalculator gradeCalculator;
	
    double markAtPassThreshold = 75.0;
    double markBelowPassThreshold = this.markAtPassThreshold - 0.01;
	
    double markAtMeritThreshold = 80.0;
    double markBelowMeritThreshold = this.markAtMeritThreshold - 0.01;
	
    double markAtDistinctionThreshold = 90.0;
    double markBelowDistinctionThreshold = this.markAtDistinctionThreshold - 0.01;
	
    double markAtValidLimit = 100.0;
    double markAboveValidLimit = this.markAtValidLimit + 0.01;
// code continues...
```

No requirement was specified that the programme be capable of handling dynamic grade classification values, but this could be introduced with minor adjustments to the implementation and test classes.

For instance, the addition of an optional overloaded constructor for the `GradeCalculator` class would enable the user to set the grade boundaries for individual class instances. It would be recommended to add tests to ensure that the custom boundaries are valid and do not overlap with each other, if this feature is added.

#### Notes on GradeCalculatorService specifications

The [Assessment](#assessment) specification dictates that a mark below 75 results in a "fail" classification - therefore no special adjustment has been made for negative marks and these will also return a "fail".

The [Assessment](#assessment) specification does not dictate behaviour for instances where marks that exceed 100.0 - in such cases the `getClassification()` method of `GradeCalculator` will return `null`.

### GroupControllerService

The `GroupControllerService` interface is implemented via the `GroupController` class located at `src/main/java/com/fdmgroup/tdd/groupcontroller/GroupController.java`.

Tests for this implementation are provided under the `GroupControllerTest.java` file located at `src/test/java/com/fdmgroup/tdd/groupcontroller/`.

The unit tests for this section of the assignment make use of [`JUnit 5`](https://junit.org/junit5/) and [`Mockito`](https://site.mockito.org/)

There are nine tests in total. Collectively, the tests verify that the `GroupController` class:
- can initialise correctly; 
- implements all methods of the `GroupControllerService` interface;
- makes expected calls to relevant methods of the `DatabaseReader` and `DatabaseWriter` classes through the use of mocks;
- passes and/or receives the expected objects to/from the relevant methods of the `DatabaseReader` and `DatabaseWriter` classes through the use of mocks.

#### Mocks

The test cases contained in `GroupControllerTest.java` make use of mock classes to facilitate testing of the `GroupController` class, for the `DatabaseReader`, `DatabaseWriter` and `Trainee` classes.

Those mocks are initialised at the top of the `GroupControllerTest` class as displayed below.

```java
// GroupControllerTest.java
// ...preceding code
public class GroupControllerTest {
	
    GroupController groupController;
    String mockTraineeUsername = "mockTraineeUsername";

    @Mock
    DatabaseReader mockDatabaseReader;

    @Mock
    DatabaseWriter mockDatabaseWriter;

    @Mock
    Trainee mockTrainee;

    @BeforeEach
    void init() {
      MockitoAnnotations.openMocks(this);
      this.groupController = new GroupController(mockDatabaseReader, mockDatabaseWriter);
    }
// code continues...
```

The [Assessment](#assessment) specifications for this assignment did not require that these mocked classes be implemented.

If implemented, further tests could be added to handle situations such as the passing of invalid class types or initialisation with invalid attributes. That is beyond the scope of this exercise and therefore tests with those functions have not been introduced here.
