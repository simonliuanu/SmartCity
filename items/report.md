# [G0 - Team Name] Report

The following is a report template to help your team successfully provide all the details necessary for your report in a structured and organised manner. Please give a straightforward and concise report that best demonstrates your project. Note that a good report will give a better impression of your project to the reviewers.

Note that you should have removed ALL TEMPLATE/INSTRUCTION textes in your submission (like the current sentence), otherwise it hampers the professionality in your documentation.

*Here are some tips to write a good report:*

* `Bullet points` are allowed and strongly encouraged for this report. Try to summarise and list the highlights of your project (rather than give long paragraphs).*

* *Try to create `diagrams` for parts that could greatly benefit from it.*

* *Try to make your report `well structured`, which is easier for the reviewers to capture the necessary information.*

*We give instructions enclosed in square brackets [...] and examples for each sections to demonstrate what are expected for your project report. Note that they only provide part of the skeleton and your description should be more content-rich. Quick references about markdown by [CommonMark](https://commonmark.org/help/)*

## Table of Contents

1. [Team Members and Roles](#team-members-and-roles)
2. [Summary of Individual Contributions](#summary-of-individual-contributions)
3. [Application Description](#application-description)
4. [Application UML](#application-uml)
5. [Application Design and Decisions](#application-design-and-decisions)
6. [Summary of Known Errors and Bugs](#summary-of-known-errors-and-bugs)
7. [Testing Summary](#testing-summary)
8. [Implemented Features](#implemented-features)
9. [Team Meetings](#team-meetings)
10. [Conflict Resolution Protocol](#conflict-resolution-protocol)

## Administrative

*Instruction: please place the CORRECT link to your firebase repository here (with comp21006442@gmail.com added as an Editor)*

- Firebase Repository Link:  https://console.firebase.google.com/project/smart-city-restaurant/overview?hl=zh-cn // TODO

  - Confirm: [X] I have already added comp21006442@gmail.com as a Editor to the Firebase project prior to due date.
  - <img src="media/report/firebase-editors.png">

- Two user accounts for markers' access are usable on the app's APK (do not change the username and password unless there are exceptional circumstances. Note that they are not real e-mail addresses in use):

  - Username: comp2100@anu.edu.au  Password: comp2100 [X] // TODO: check if done
  - Username: comp6442@anu.edu.au  Password: comp6442 [X] // TODO: check if done

## Team Members and Roles

The key area(s) of responsibilities for each member

| UID      |     Name      |      Role |
| :------- | :-----------: | --------: |
| u7841935 |  Rongze Gao   | Developer |
| u7811526 | Shengzong Dai | Developer |
| u7761758 |   Simon Liu   | Developer |
| u7615711 |  Tianfa Zhu   | Developer |
| u7810157 |   Yuheng Li   | Developer |

## Summary of Individual Contributions

Specific details of individual contribution of each member to the project.

Each team member is responsible for writing **their own subsection**.

A generic summary will not be acceptable and may result in a significant lose of marks.

*[Summarise the contributions made by each member to the project, e.g. code implementation, code design, UI design, report writing, etc.]*

*[Code Implementation. Which features did you implement? Which classes or methods was each member involved in? Provide an approximate proportion in pecentage of the contribution of each member to the whole code implementation, e.g. 30%.]*

*you should ALSO provide links to the specified classes and/or functions*
Note that the core criteria of contribution is based on `code contribution` (the technical developing of the App).

*Here is an example: (Note that you should remove the entire section (e.g. "others") if it is not applicable)*

1. **UID1, Name1**  I have 30% contribution, as follows: <br>
   - **Code Contribution in the final App**

     - Feature A1, A2, A3 - class Dummy: [Dummy.java](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java)
     - XYZ Design Pattern -  class AnotherClass: [functionOne()](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43), [function2()](the-URL)
     - ... (any other contribution in the code, including UI and data files) ... [Student class](../src/path/to/class/Student.java), ..., etc.*, [LanguageTranslator class](../src/path/to/class/LanguageTranslator.java): function1(), function2(), ... <br><br>

   - **Code and App Design** 

     - [What design patterns, data structures, did the involved member propose?]*
     - [UI Design. Specify what design did the involved member propose? What tools were used for the design?]* <br><br>

   - **Others**: (only if significant and significantly different from an "average contribution") 

     - [Report Writing?] [Slides preparation?]*
     - [You are welcome to provide anything that you consider as a contribution to the project or team.] e.g., APK, setups, firebase* <br><br>
2. **u7810157, Yuheng Li**  I have 25% contribution, as follows: <br>
   - **Code Contribution in the final App**

     - Feature [DataFiles], [DataStream] - class: [RES_dataSet](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/RES_dataSet_one_line.json?ref_type=heads),[CommentActivity](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/activity/CommentActivity.java?ref_type=heads),[CommentAdapter](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/adapter/CommentAdapter.java?ref_type=heads),[Comment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/entity/Comment.java?ref_type=heads)
     - Factory Design Pattern -  class CommentFactory: [CommentFactory](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/CommentFactory.java?ref_type=heads),[CommentItem](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/CommentItem.java?ref_type=heads),[ContentInComment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/ContentInComment.java?ref_type=heads),[UsernameInComment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/UsernameInComment.java?ref_type=heads)
     - UI files: [res_comment.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/res_comment.xml?ref_type=heads)
     - (any other contribution in the code, including UI and data files) ... [Student class](../src/path/to/class/Student.java), ..., etc.*, [LanguageTranslator class](../src/path/to/class/LanguageTranslator.java): function1(), function2(), ... <br><br>

   - **Code and App Design** 

     - [Factroy design pattern]*
     - [UML design. Specify what design did the involved member propose? What tools were used for the design?]* <br><br>

   - **Others**: (only if significant and significantly different from an "average contribution") 

     - [Report Writing?] [Slides preparation?]*
     - [You are welcome to provide anything that you consider as a contribution to the project or team.] e.g., APK, setups, firebase* <br><br>
3. **u7811526, Shengzong Dai**  I have 25% contribution, as follows: <br>
   - **Code Contribution in the final App**
     - Feature [LogIn] , [LoadShowData], [Interact-Follow], [UXUI]
       - class Login: [LoginActivity.java](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java), [ItemListAdapter.java](), [Firebase](), [ItemFragment.java](), [MeFragment.java](),  
     - Singleton Design Pattern -  class User, LikeRestaurant: [functionOne()](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43), [function2()](the-URL)
     - Observer Design Pattern -  class LikeRestaurant: [functionOne()](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43), [function2()](the-URL)
     - Iterator Design Pattern -  class RestaurantRepository: [functionOne()](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43), [function2()](the-URL)
     - UI files: [bottom_navi.xml](), [activity_login.xml](), [activity_main.xml](), [fragment_item.xml](), [item_list.xml]()
     - ... (any other contribution in the code, including UI and data files) ... [Student class](../src/path/to/class/Student.java), ..., etc.*, [LanguageTranslator class](../src/path/to/class/LanguageTranslator.java): function1(), function2(), ... <br><br>
   - **Code and App Design** 
     - I use Iterator pattern to optimize load show data, use singleton to optimize user collected restaurants, and use observer pattern to optimize grouped effect on 'me' page
     - [What design patterns, data structures, did the involved member propose?]*
     - [UI Design. Specify what design did the involved member propose? What tools were used for the design?]* <br><br>
   - **Others**: (only if significant and significantly different from an "average contribution") 

     - [Report Writing?] [Slides preparation?]*
     - [Set up firebase.] e.g., APK, setups, firebase* <br><br>

4. **u7615711, Tianfa Zhu**  I have 20% contribution, as follows: <br>
   - **Code Contribution in the final App**

     - Feature [UXUI] - class: [MainActivity.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/activity/MainActivity.java?ref_type=heads)
     - UI files: layout:[fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_home.xml?ref_type=heads),[fragment_map.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_map.xml?ref_type=heads),[fragment_me.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_me.xml?ref_type=heads),[comment_item.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/comment_item.xml?ref_type=heads), [rounded_background.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/drawable/rounded_background.xml?ref_type=heads),[button_background.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/drawable/button_background.xml?ref_type=heads); 
     layout(landscape):[fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/fragment_home.xml?ref_type=heads),[fragment_me.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/fragment_me.xml?ref_type=heads),[res_comment.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/res_comment.xml?ref_type=heads).
     - (any other contribution in the code, including UI and data files) ... [Student class](../src/path/to/class/Student.java), ..., etc.*, [LanguageTranslator class](../src/path/to/class/LanguageTranslator.java): function1(), function2(), ... <br><br>

   - **Code and App Design** 

     - [What design patterns, data structures, did the involved member propose?]*
     - [UI Design. Specify what design did the involved member propose? What tools were used for the design?]* <br><br>

   - **Others**: (only if significant and significantly different from an "average contribution") 

     - [Report Writing?] [Slides preparation?]*
     - [You are welcome to provide anything that you consider as a contribution to the project or team.] e.g., APK, setups, firebase* <br><br>


## Application Description

*[What is your application, what does it do? Include photos or diagrams if necessary]*

*Here is a pet specific application example*

*PetBook is a social media application specifically targetting pet owners... it provides... certified practitioners, such as veterians are indicated by a label next to their profile...*

### Problem Statement

*[Problem statement that defines the purpose of your App]*

### Application Use Cases and/or Examples

*[Provide use cases and examples of people using your application. Who are the target users of your application? How do the users use your application?]*

*Here is a pet training application example*

*Molly wants to inquiry about her cat, McPurr's recent troublesome behaviour*

1. *Molly notices that McPurr has been hostile since...*
2. *She makes a post about... with the tag...*
3. *Lachlan, a vet, writes a reply to Molly's post...*
4. ...
5. *Molly gives Lachlan's reply a 'tick' response*

*Here is a map navigation application example*

*Targets Users: Drivers*

* *Users can use it to navigate in order to reach the destinations.*
* *Users can learn the traffic conditions*
* ...

*Target Users: Those who want to find some good restaurants*

* *Users can find nearby restaurants and the application can give recommendations*
* ...

*List all the use cases in text descriptions or create use case diagrams. Please refer to https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-use-case-diagram/ for use case diagram.*

<hr>


### Application UML

![ClassDiagram]() <br>
Description about the class diagram:

<hr>


## Code Design and Decisions

This is an important section of your report and should include all technical decisions made. Well-written justifications will increase your marks for both the report as well as for the relevant parts (e.g., data structure). This includes, for example,

- Details about the parser (describe the formal grammar and language used)
- Decisions made (e.g., explain why you chose one or another data structure, why you used a specific data model, etc.)
- Details about the design patterns used (where in the code, justification of the choice, etc)

*Please give clear and concise descriptions for each subsections of this part. It would be better to list all the concrete items for each subsection and give no more than `5` concise, crucial reasons of your design.

<hr>


### Data Structures

*[What data structures did your team utilise? Where and why?]*

Here is a partial (short) example for the subsection `Data Structures`:*

*I used the following data structures in my project:*

1. *AvlTree*
   * ***Objective**: Used for storing restaurant data in a balanced search tree for the search feature. The AVL tree ensures efficient lookups, insertions, and deletions, enabling the application to quickly retrieve restaurant information based on user queries.*
   * **Code Locations**: Defined in [AvlTree.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/dataStructure/AvlTree.java?ref_type=heads), and initialized in [AvlTreeManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/dataStructure/AvlTreeManager.java?ref_type=heads).
   * *Reasons:*
     * The AVL tree is self-balancing, ensuring a time complexity of O(log n) for insertions, deletions, and lookups. This makes it more efficient than using an unsorted array or list when handling a large dataset of restaurants.
     * AVL trees are ideal for the restaurant search feature because the balanced nature ensures that no matter how large the dataset grows, search performance remains optimal.
     * We don’t need to access restaurants by index, which would make an array-based structure less suitable. Instead, the tree structure allows for quick retrieval based on comparisons (e.g., restaurant names or locations).
     * For restaurant queries, the tree’s ordering and balancing help provide both exact and suggested results based on user input, particularly when implementing fuzzy matching.

2. ...

3. ...

<hr>


### Design Patterns

*[What design patterns did your team utilise? Where and why?]*

1. *xxx Pattern*

   * *Objective: used for storing xxxx for xxx feature.*
   * *Code Locations: defined in [Class X, methods Z, Y](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and [class AnotherClass, lines l1-l2](url); processed using [dataStructureHandlerMethod](url) and ...
   * *Reasons:*

2. *Data Access Object Pattern(DAO)*

   * *Objective: used for .*
   * *Code Locations: defined in [Class ItemDao](), [ItemDaoImpl]() , [UserDao](), [UserDaoImpl](); processed using [initialItemList]() and [checkUser]()*
   * *Reasons:*
   
   ​    Our project use firebase real time database as a persistence database to store the data, in order to not to expose details of the data storage and the way to access to database, we choose to use DAO to centralize the data access logic of the application to simplify business logic and facilitate data operations.
   
   ​    When need to change the data source or modify the data access logic, we can only work on the data layer and do not affect other layers.

3. *Singleton Pattern*

   * *Objective: used for .*

   * *Code Locations: defined in [Class ItemDao](), [ItemDaoImpl]() , [UserDao](), [UserDaoImpl](); processed using [initialItemList]() and [checkUser]()*
   * *Reasons:*

   ​    LikeRestaurant as a class to manage the restaurants that be collected (like) by user, when user add restaurant on  'Home' or 'Item' page, the data could update immediately on 'Me' page, as the basic feature [Intera-Micro] asked to store in memory, singleton meets the requirement to provide a class as a global access point to access the instance. In this way, we can store the data conveniently and reduce the memory usage.
   ​     

4. *Iterator Pattern*

   * *Objective: used for .*

   * Code Locations: defined in [Class Container](), [RestaurantRepository](), [RestaurantIterator](); processed using Method [hasNext]() and [next]()
   * *Reasons:*

   ​    To meet the feature [LoadShowData] on 'Item' page, we need to show the restaurants data that we stored in firebase. But more than 3500 data is a huge number and it would be slow if load one time, so we choose to distribute these data in different pages with 12 items per page. In this way, iterator is helpful to manage the data, we can justify if the next page is null or not to show a right page. 

5. Factory Pattern

   * *Objective: used for .*

   * Code Locations: defined in [Class Factory](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/CommentFactory.java?ref_type=heads), [CommentItem](),[ContentInComment](),[UsernameInComment](); processed using Method [CommentActivity]()
   * *Reasons:*

       In order to meet the requirements of high-quality code, I decided to use the factory pattern here to generate comment content. By using the factory pattern, the object creation logic can be encapsulated in a factory class instead of directly instantiating the object in the client code. The advantages of doing so are: 1: The programmer who calls the comment object only needs to know whether he needs to call username or comment to create different objects in the comment. 2: High scalability. If someone need to add a new comment object, he/she only need to extend a factory class. 3: The specific implementation of the comment is shielded, and the developer who calls the comment object only cares about the interface he needs.

<hr>


### Parser

### <u>Grammar(s)</u>

The parser's primary function is to validate and correct tokens by comparing them against this list using the Levenshtein distance algorithm.

The parser operates based on a predefined list of **valid tokens** which are imported from item names imported from Firebase.

Production Rules:

```
<Sentence> ::= <Token>+
<Token> ::= <ValidToken>
```

**Advantages of This Design:**

1. **Simplicity:**
   - **Ease of Implementation:** The parser is straightforward to implement and maintain.
   - **Minimal Overhead:** There's no need for complex parsing tables or state machines, which reduces computational overhead.
2. **Flexibility:**
   - **Dynamic Validation:** The list of valid tokens can be easily updated or extended without altering the underlying parsing logic.
   - **Domain Adaptability:** Suitable for applications where the vocabulary is well-defined and can be enumerated.
3. **Error Correction:**
   - **Robustness:** By finding the closest valid token, the parser can correct minor typographical errors, enhancing user experience.

### <u>Tokenizers and Parsers</u>

**Tokenizer (`Tokenizer` Class):**

- **Purpose:** Breaks down input queries into individual tokens based on whitespace.
- **Usage Scenario:** When a user inputs a query or command, the tokenizer processes the raw string to create a manageable list of tokens for further processing.

**Parser (`Parser` Class):**

- **Purpose:** Validates and corrects tokens by comparing them against a list of predefined valid tokens.
- **Usage Scenario:** After tokenization, the parser ensures that each token is recognized and corrects any discrepancies, such as typographical errors, before the tokens are used in the application’s logic.

<hr>


### Others

*[What other design decisions have you made which you feel are relevant? Feel free to separate these into their own subheadings.]*

<br>

<hr>


## Implemented Features

*[What features have you implemented? where, how, and why?]* <br>
*List all features you have completed in their separate categories with their featureId. THe features must be one of the basic/custom features, or an approved feature from Voice Four Feature.*

### Basic Features

1. [LogIn]. Description of the feature ... (easy)

   * Code: LoginActivity, UserDao, UserDaoImple
   * Description of feature: User can use the fixed account to login <br>
   * Description of your implementation: We store the user's login information (username and password) in the Firebase's [Firestore database]([smart-city-restaurant – Cloud Firestore – Data – Firebase console (google.com)](https://console.firebase.google.com/project/smart-city-restaurant/firestore/databases/-default-/data/~2Fusers~2Fcomp2100))), so that when the user logs in, the information stored in the database is compared and verified.  And when the user enters an empty or incorrect account/password, the app will give a corresponding prompt. <br>

2. [DataFiles]. Description of the feature(easy)

   * Code to the Data File: <a href="[SmartCity/app/src/main/assets/RES_dataSet_reordered_one_line_2.json · dev · Yuheng Li / gp-24s2 · GitLab (anu.edu.au)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/assets/RES_dataSet_reordered_one_line_2.json?ref_type=heads)">assets</a>
   * Link to the Firebase repo: <a href="[smart-city-restaurant - Realtime Database - 数据 - Firebase 控制台 (google.com)](https://console.firebase.google.com/project/smart-city-restaurant/database/smart-city-restaurant-default-rtdb/data/~2Frestaurants?hl=zh-cn)">firebase</a>
   * Description of your implementation:I obtained the official open map API interface of Google from the Google Cloud Console, and obtained the restaurant data we needed from Google Maps through the Google API interface. Then I wrote a script program in Python to crawl data through the API interface. This script uses a simple grid method to generate search locations from several major cities in Australia. Each city has about 10 to 30 search locations (depending on the size of the city), with a search radius of 1,000 meters. The search keywords are restaurant, cafe, bar, and the information obtained includes name, image URL, rating, address, latitude and longitude, price level and restaurant category. Finally, the results are saved in JSON format.

3. [LoadShowData]

   * Code: [ItemListAdapter](), [ItemFragment](), [RestaurantRepository]()
   * Description of feature: The app load and display data instances from the data set. <br>
   * Description of your implementation:  We stored the restaurant data in Firebase's [Realtime Database]([smart-city-restaurant – Realtime Database – Data – Firebase console (google.com)](https://console.firebase.google.com/project/smart-city-restaurant/database/smart-city-restaurant-default-rtdb/data/~2Frestaurants)) because it works well with JSON-formatted data. Additionally, we created a corresponding `Restaurant` class with properties that map directly to the JSON structure, allowing for seamless data reading and display. As we have 3,500 records, we implemented pagination to prevent overloading the system by loading too much data at once. Each page displays 12 records, and users can click "load more data" to view the next set of data. To achieve this, we used the Iterator pattern in the implementation.<br>

4. [DataStream]

   * Code: [CommentActivity](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/activity/CommentActivity.java?ref_type=heads),[CommentAdapter](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/adapter/CommentAdapter.java?ref_type=heads),[CommentFactory](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/CommentFactory.java?ref_type=heads),[Comment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/entity/Comment.java?ref_type=heads)
   * Description of feature:Users can click every single restaurant and jump to new page with details and comments. The comment can be generated by system automatically,and user can submit their own comments on it, it excatly simulate the datastream between the users and other users.<br>
   * Description of your implementation:First we need to set click listener on ever item showed in the list, and then we design the new page's [UI](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/res_comment.xml?ref_type=heads#L1) for comment and write a new class `comment` to represent the comments show under the restaurants with factory design pattern. Secondly, we design the activity and adapter for comment page to show the details of certain restaurant and generate the comment normally, we apply `thread` in it and set the time gap as 2~3 seconds. Finally, we designed a lot of contents and usernames for every comment and let them loaded in comment page successfully.<br>

5. [Search]

6. [UXUI]

   - Code: LoginActivity, UserDao, UserDaoImple
   - Description of feature: User  can use the fixed account to login 
   - Description of your implementation: Store the users' information in firebase 

7. [UIFeedback]

   - Code: LoginActivity, UserDao, UserDaoImple
   - Description of feature: User  can use the fixed account to login 
   - Description of your implementation: Store the users' information in firebase 

   <br>

### Custom Features

Feature Category: Privacy <br>

1. [Privacy-Request]. Description of the feature  (easy)

   * Code: [Class X, methods Z, Y](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...

   * Description of your implementation: ... <br>

     <br>

2. [Privacy-Block]. Description ... ... (medium)
   ... ...
   <br><br>

Feature Category: Firebase Integration <br>

3. [FB-Auth] Description of the feature (easy)

* Code: [Class X, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43) and Class Y, ...
* [Class B](../src/path/to/class/file.java#L30-85): methods A, B, C, lines of code: 30 to 85
* Description of your implementation: ... <br>

<hr>


### Surprise Feature

*Instructions:*

- If implemented, explain how your solution addresses the task (any detail requirements will be released with the surprise feature specifications).
- State that "Surprise feature is not implemented" otherwise.

<br> <hr>

## Testing Summary

*[What features have you tested? What is your testing coverage?]*
*Please provide details (see rubrics) including some screenshots of your testing summary, showing the achieved testing coverage. Feel free to provide further details on your tests.*

*Here is an example:*

1. Tests for Search

   - Code: [TokenizerTest Class, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java) for the [Tokenizer Class, entire file](https://gitlab.cecs.anu.edu.au/comp2100/group-project/ga-23s2/-/blob/main/items/media/_examples/Dummy.java#L22-43)
   - *Number of test cases: ...*
   - *Code coverage: ...*
   - *Types of tests created and descriptions: ...*

2. xxx

...

<br> <hr>

## Summary of Known Errors and Bugs

*[Where are the known errors and bugs? What consequences might they lead to?]*
*List all the known errors and bugs here. If we find bugs/errors that your team does not know of, it shows that your testing is not thorough.*

*Here is an example:*

1. *Bug 1:*

   - *A space bar (' ') in the sign in email will crash the application.*
   - ...

2. *Bug 2:*

3. ...

<br> <hr>

## Team Management

### Meeting Minutes

* Link to the minutes of your meetings like above. There must be at least 4 team meetings.
  (each committed within 2 days after the meeting)
* Your meetings should also have a reasonable date spanning across Week 6 to 11.*

- *[Team Meeting 1](link_to_md_file.md)*
- ...
- ...
- [Team Meeting 4](link_to_md_file.md)
- ... (Add any descriptions if needed) ...

<hr>


### Conflict Resolution Protocol

*[Write a well defined protocol your team can use to handle conflicts. That is, if your group has problems, what is the procedure for reaching consensus or solving a problem?
(If you choose to make this an external document, link to it here)]*

*If your group has issues, how will your group reach consensus or solve the problem?*
*- e.g., if a member gets sick, what is the solution? Alternatively, what is your plan to mitigate the impact of unforeseen incidents for this 6-to-8-week project?*

This shall include an agreed procedure for situations including (but not limited to):

- A member is sick in the final week of the project.
- A member didn't complete the assigned task which should've been completed before the checkpoint, and the checkpoint is approaching.
- A member is unreachable (didn't respond messages in your agreed communication channels and emails in two days).
- The team have different understandings toward the requirement of the assignment.