# AY2020/20 CS2113 Team project

##  List of Team Task

1. Setting up the GitHub team org/repo
2. Necessary general code enhancements
3. Setting up tools e.g., GitHub, Gradle
4. Maintaining the issue tracker
5. Release management
6. Updating user/developer docs that are not specific to a feature e.g. documenting the target user profile
7. Incorporating more useful tools/libraries/frameworks into the product or the project workflow (e.g. automate more aspects of the project workflow using a GitHub plugin)



## List of Roles and Responsibilities

- *Team lead*: Responsible for overall project coordination.
- *Documentation* (short for ‘in charge of documentation’): Responsible for the quality of various project documents.
- *Testing*: Ensures the testing of the project is done properly and on time.
- *Code quality*: Looks after code quality, ensures adherence to coding standards, etc.
- *Deliverables and deadlines*: Ensure project deliverables are done on time and in the right format.
- *Integration*: In charge of versioning of the code, maintaining the code repository, integrating various parts of the software to create a whole.
- *Scheduling and tracking*: In charge of defining, assigning, and tracking project tasks.
- *[Tool ABC] expert*: e.g. Intellij expert, Git expert, etc. Helps other team member with matters related to the specific tool.

- *In charge of [Area XYZ]* of the code: e.g. In charge of the code that deals with storage, etc. If you are in charge of an area, you are expected to know that area well, and review changes done to that code.



## Constraints

####  **Constraint-Typing-Preferred**

The product should be targeting users who can type fast and prefer typing over other means of input.
**Reason**: to increase comparability of products, and to make feature evaluation easier for peer evaluators.

####  **Constraint-Single-User**

The product should be for a single user i.e. (not a multi-user product).
**Reason**: multi-user systems are hard to test, which is unfair for peer testers who will be graded based on the number of bugs they find.

####  **Constraint-Incremental**

The product needs to be developed in a breadth-first incremental manner over the project duration. While it is fine to do less in some weeks and more in other weeks, a reasonably consistent delivery rate is expected. For example, it is not acceptable to do the entire project over the recess week and do almost nothing for the remainder of the semester.
**Reasons**: 1. To simulate a real project where you have to work on a code base over a long period, possibly with breaks in the middle. 2. To learn how to deliver big features in small increments.

####  **Constraint-Human-Editable-File**

The data should be stored locally and should be in a human editable text file.
**Reason:** To allow advanced users to manipulate the data by editing the data file.

####  **Constraint-No-DBMS**

Do not use a DBMS to store data.
**Reason:** Using a DBMS to store data will reduce the room to apply OOP techniques to manage data. It is true that most real world systems use a DBMS, but given the small size of this project, we need to optimize it for CS2113/T module learning outcomes; covering DBMS-related topics will have to be left to database modules or level 3 project modules.

####  **Constraint-OO**

The software should follow the Object-oriented paradigm primarily (but you are allowed to mix in a bit other styles when justifiable).
**Reason:** For you to practice using OOP in a non-trivial project.

####  **Constraint-Platform-Independent**

The software should work on the Windows, Linux, and OS-X platforms. Even if you are unable to manually test the app on all three platforms, deliberately avoid using OS-dependent libraries and OS-specific features.
**Reason:** Peer testers should be able to use any of these platforms.

####  **Constraint-Java-Version**

The software should work on a computer that has version 11 of Java i.e., no other Java version installed.

####  **Constraint-Portable**

The software should work without requiring an installer.
**Reason:** Testers may not want to install your product on their computer.

####  **Constraint-No-Remote-Server**

The software should not depend on your own remote server.
**Reason:** Anyone should be able to use/test your app any time, even after the semester is over.

####  **Constraint-External-Software**

The use of third-party frameworks/libraries is allowed but only if they,

- are free, open-source, and have permissive license terms (E.g., trial version of libraries that require purchase after N days are not allowed).
- do not require any installation by the user of your software.
- do not violate other constraints.

and is subjected to prior approval by the teaching team.
**Reason:** We will not allow third-party software that can interfere with the learning objectives of the module.

Please post in the [forum](https://github.com/nus-cs2113-AY2021S1/forum/issues) your request to use a third-party libraries *before* you start using the library. Once a specific library has been approved for one team, other teams may use it without requesting permission again.
**Reason:** The whole class should know which external software are used by others so that they can do the same if they wish to.

####  **Constraint-File-Size**

The file sizes of the deliverables should not exceed the limits given below.

%%**Reason:** It is hard to download big files during the practical exam due to limited WiFi bandwidth at the venue%%:

- JAR file: 100Mb (Some third-party software -- e.g., Stanford NLP library, certain graphics libraries -- can cause you to exceed this limit)
- PDF files: 15Mb/file (Not following [the recommended method of converting to PDF format](https://se-education.org/guides/tutorials/savingPdf.html) can cause big PDF files. Another cause is using unnecessarily high resolution images for screenshots).



## Recommended Add-Ons

####  **Recommendation-Minimal-Network**

It is OK to use a reliable public API e.g., Google search but we recommend that you have a fallback mechanism (e.g., able to load data using a data file if the network is down).
**Reason:** During the mass peer-testing session, the network access can be intermittent due to high load. If your feature cannot be tested due to lack of Internet, that will have to be counted as a major bug, to be fair to those whose app is being tested and bugs found being penalized.
If you use NUS data (e.g., scrape data from an NUS website), please work with [NUS IT](https://nusit.nus.edu.sg/contact-us/) directly to get their approval first. Even well-intentioned use of NUS data without approval can get you into serious trouble (has happened before). The teaching team will not be able to get approval for you as the use of NUS data is not a module requirement.

####  **Recommendation-Testability**

Avoid implementing hard-to-test (both for manual testing as well as automated testing) features or features that make your product hard-to-test.
**Reason**: *testability* is a grading criterion. If you choose to implement such a feature, you will need to spend an extra effort to reach an acceptable level of testability. Here are some examples of features that are hard-to-test:

- Features that depend heavily on remote APIs: Those APIs can block your access if they mistake your automated tests as a bot attack. Some remote APIs require setting up accounts, keys, login etc, that will irritate the testers of your product and give a low rating to the testability of your work.
- Audio-related features: The peer testing of your product is done under exam conditions where it is not appropriate to play audio.
- Features that require creating user accounts, login, logout etc.

#### **Recommendation-No-GUI**

Creating a good Java GUI takes a lot of extra effort, which can easily push the tP effort beyond the expected range. In addition, good GUI design is not a learning outcome of this module. Therefore, you are strongly discouraged from creating a GUI application. Choose the GUI path only if you are willing to take the extra workload on top of the module's normal load.

####  **Recommendation-CLI-First**

Following from the *Constraint-Typing-Preferred*, if the app is optimized for the target user (graded under the *product design* criterion), a user who can type fast should be able to accomplish most tasks faster via CLI, compared to a hypothetical GUI-only version of the app. For example, adding a new entity via the CLI should be faster than entering the same data through a GUI form.
Therefore, the input to the app needs to be primarily CLI. If you do implement a GUI, that GUI should primarily be used to give visual feedback to the user. While we don't prohibit non-CLI inputs, note that such inputs will reduce the suitability of the product to target users. Therefore, give CLI alternatives to mouse/GUI inputs, if applicable.
Also keep in mind:

- Regular typing is usually faster than using key combinations.
- One-shot commands are faster over multi-step commands. If you provide a multi-step command to help new users, you can also provide a one-shot equivalent for regular/expert users.



## Grading

| Criterion                   | Unable to judge | Low                                                     | Medium                                                       | High                                                         |
| --------------------------- | --------------- | ------------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `target user`               | Not specified   |                                                         |                                                              | Clearly specified and narrowed down appropriately            |
| `value proposition`         | Not specified   | The value to target user is low. App is not worth using | Some small group of target users might find the app worth using | Most of the target users are likely to find the app worth using |
| `optimized for target user` |                 | Not enough focus for CLI users                          | Mostly CLI-based, but cumbersome to use most of the time     | Feels like a fast typist can be more productive with the app, compared to an equivalent GUI app without a CLI |
| `feature-fit`               |                 | Many of the features don't fit with others              | Most features fit together but a few may be possible misfits | All features fit together to for a cohesive whole            |