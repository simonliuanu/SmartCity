# [G16 - Five Coders] Report

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
| u7811526 | Shengzong Dai | Leader    |
| u7761758 |   Simon Liu   | Developer |
| u7615711 |  Tianfa Zhu   | Designer  |
| u7810157 |   Yuheng Li   | Developer |

## Summary of Individual Contributions

Specific details of individual contribution of each member to the project.

1. **u7841935, Rongze Gao**  I have 20% contribution, as follows: <br>
   - **Code Contribution in the final App**

   - Feature:
     - [Data-GPS] - class MapFragment: [MapFragment.java]()
     - [P2P-DM] - class ChatFragment: [ChatFragment.java](), SearchUserActivity: [SearchUserActivity.java](), ChatActivity.java: [ChatActivity.java]()
     - [UXUI]
      
   - Design Pattern 
     - Model-View-Controller (MVC) Pattern 
         - Model class FirebaseUtil: [FirebaseUtil.java](), UserUtil: [UserUtil.java]()
         - View class RecentChatAdapter: [RecentChatAdapter.java](), SearchUserAdapter: [SearchUserAdapter.java](), MessageAdapter: [MessageAdapter.java]()
         - Controller class [P2P-DM] feature classes
     - Singleton Pattern - class MapRestaurantCache: [MapRestaurantCache.java](), UserCache: [UserCache.java]()

  - UI files: [fragment_chat.xml](), [activity_search_user.xml](), [activity_chat.xml](), [recent_chat_view.xml](), [search_user_view.xml](), [message_view.xml]()

  - **Others**: Assisted Data Verification

2. **u7810157, Yuheng Li**  I have 20% contribution, as follows: <br>
   - **Code Contribution in the final App**

     - Features: 
        - [DataFiles] - class: [RES_dataSet](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/assets/RES_dataSet.json?ref_type=heads)
        - [DataStream] 
          - class activity: [CommentActivity](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/CommentActivity.java?ref_type=heads)
          - class adapter: [CommentAdapter](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/CommentAdapter.java?ref_type=heads)
          - concrete class: [Comment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/Comment.java?ref_type=heads)
     - Design pattern:
        - Factory Design Pattern
          - class CommentFactory: [CommentFactory](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/factory/CommentFactory.java?ref_type=heads),
          - interface CommentItem: [CommentItem](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/factory/CommentItem.java?ref_type=heads)
          - class implement in content: [ContentInComment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/factory/ContentInComment.java?ref_type=heads)
          - class implement in username: [UsernameInComment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/factory/UsernameInComment.java?ref_type=heads)
     - UI files: [res_comment.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/res_comment.xml?ref_type=heads)
     - Data fetching：[RES_dataSet](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/assets/RES_dataSet.json?ref_type=heads)
     - Data cleaning and formatting：[commit history](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/commit/f265d991c4269d03c2f8d47feeba9ec437f73a20)
     <br>
- **Code and App Design**

     - I purposed following items: 
        - Design pattern:[Factroy design pattern]
        - Datastructure: [Arraylist]
        - UI design: I design the basic layout in comment page[res_comment.xml]
        - UML design:
          - [User case diagram]
          - [Class diagram for whole class]
          - [Class diagram for data structure]
          - [Class diagram for design pattern]<br>

   - **Others**:
     - [Report writing for Application Description part]*
     <br><br>
3. **u7811526, Shengzong Dai**  I have 20% contribution, as follows: <br>

- **Code Contribution in the final App**
  - Features:

    - [LogIn] - class: [LoginActivity.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads)
    - [LoadShowData] - class:  [ItemListAdapter.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/ItemListAdapter.java?ref_type=heads), [ItemFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads)
    - [Interact-Follow] - class: [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads)
    - [[UXUI] - class:
  - Design Pattern: 

    - Singleton Pattern 
      - class [User.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/User.java?ref_type=heads): [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/User.java?ref_type=heads)
      - class [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads): [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads#L30-32)
    - Observer Pattern 
      - Subject: class: [Subject.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/Subject.java?ref_type=heads)
      - Concrete Subject: [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads): [line 21 - 66](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads#L41-92)
      - Observer: [LikeRestaurantObserver.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurantObserver.java?ref_type=heads)
      - Concrete Observer: [filterRes](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L71) implemented by [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads): [line 112 - 144](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L112-144), 
    - Iterator Pattern
      - Collection: [Container.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/Container.java?ref_type=heads)
      - Concrete collection: [RestaurantRepository.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/RestaurantRepository.java?ref_type=heads)
      - Concrete interator: [RestaurantIterator](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/RestaurantRepository.java?ref_type=heads#L36-70) (inner class)
      - Implement in: class [ItemFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads): [line 89 - 110](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L89-110)  with method [loadMoreData](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L144-150)
    - DAO Pattern
      - Interface: [ItemDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDao.java?ref_type=heads), [UserDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDao.java?ref_type=heads)
      - Implement: [ItemDaoImpl.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDaoImpl.java?ref_type=heads), [UserDaoImpl.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDaoImpl.java?ref_type=heads)
      - Used in: ItemDao - [MeFragment.java line 76 - 77](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L76-77), UserDao - [LoginActivity method checkUser](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads#L118-140) and [line 50 - 51](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads#L50-51)
  - UI files: [bottom_navi.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/tree/main/SmartCity/app/src/main/res/menu?ref_type=heads)(part), [activity_login.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/activity_login.xml?ref_type=heads), [activity_main.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/activity_main.xml?ref_type=heads)(part), [fragment_item.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/fragment_item.xml?ref_type=heads)(part), [item_list.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blame/main/SmartCity/app/src/main/res/layout/item_list.xml?ref_type=heads#L2), [moredata.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/moredata.xml?ref_type=heads)

    <br>

- **Code and App Design** 

  - I proposed following items: 
    - Design pattern: [singleton pattern], [observer pattern], [iterator pattern] and [dao pattern]. 	
    - Datastructure: [Arraylist]
    - Database: store in firebase
  - UI Design: I design the theme color and layout location of the project <br><br>

- **Others**: (only if significant and significantly different from an "average contribution") 
  - setup firebase <br><br>

4. **u7615711, Tianfa Zhu**  I have 20% contribution, as follows: <br>
   - **Code Contribution in the final App**

     - Feature [UXUI] - class: [MainActivity.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/activity/MainActivity.java?ref_type=heads)
     - Feature [UIFeedback] - [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads)
     
     - UI files: layout:[fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_home.xml?ref_type=heads),[fragment_map.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_map.xml?ref_type=heads),[fragment_me.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_me.xml?ref_type=heads),[comment_item.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/comment_item.xml?ref_type=heads), [rounded_background.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/drawable/rounded_background.xml?ref_type=heads),[button_background.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/drawable/button_background.xml?ref_type=heads); 
     layout(landscape):[fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/fragment_home.xml?ref_type=heads),[fragment_me.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/fragment_me.xml?ref_type=heads),[res_comment.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/res_comment.xml?ref_type=heads).
     

   - **Code and App Design** 

     - [UI Design. I adopted a clean and clear design language, using a top bar and bottom navigation bar across almost all pages. Furthermore, I ensured a consistent color scheme for the top bar, navigation bar, and buttons.]* <br><br>

5. **u7765758, Simon Liu**  I have 20% contribution, as follows: <br>

    - **Code Contribution in the final App**
        - Features - Basic: [Search](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BSearch%5D%20The,this%20purpose.%20(medium)), 
        Custom: [Search-Invalid](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BSearch%2DInvalid%5D,this%20feature.%20(medium)), [Search-Filter](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BSearch%2DFilter%5D%20The%20app%20must%20provide%20functionality%20to%20sort%20and%20filter%20a%20list%20of%20items%20returned%20from%20searches%20using%20appropriate%20UI%20components.%20(easy))<br>
            Since these features are closely related, I have grouped the classes I contributed together:
            - [Tokenizer.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Tokenizer.java?ref_type=heads)
            - [Parser.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Parser.java?ref_type=heads)
            - [AvlTree.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTree.java?ref_type=heads)
            - [AvlTreeManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTreeManager.java?ref_type=heads)
            - [Restaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/Restaurant.java?ref_type=heads)
            - [RestaurantManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/RestaurantManager.java?ref_type=heads)
            - [HomeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/HomeFragment.java?ref_type=heads)
        - UI file: [fragment_home](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/fragment_home.xml?ref_type=heads)(part)

    - **Code and App Design**
      - Design Pattern: [Singleton Pattern]
        - [AvlTreeManager.getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTreeManager.java#L18)
            Implemented Singleton pattern to ensure that there is only one instance of AvlTreeManager in the application.
      - Data Structure: [AvlTree](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTree.java?ref_type=heads) to store restaurant data (it's using generic type, so it can be used to store any type of data, expanding the code's reusability)
      - Unit Testing:
        - [AvlTreeTest.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/test/java/com/example/smartcity/AvlTreeTest.java)
        - [AvlTreeManagerTest.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/test/java/com/example/smartcity/AvlTreeManagerTest.java)
        - [ParserTest.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/test/java/com/example/smartcity/ParserTest.java)
        - [TokenizerTest.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/test/java/com/example/smartcity/TokenizerTest.java)

    - **Others**:
        - [Team Meeting] - I have scribed team meeting record [one](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-one.md?ref_type=heads) and [three](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-three.md?ref_type=heads).
## Application Description

*CityTastes is a food lovers' social media app. In this regard, the app will give users the capabilities of searching for restaurants quite conveniently. They are allowed to look for a restaurant by typing down the name or using GPS by pinning their location in order to view the nearby restaurants and save their favorite restaurants by categorizing them. This will let people share reviews, have discussions, and converse with friends in regard to dining out.*

### Problem Statement

*[Our app helps users discoveries of new restaurants by searching either via name or GPS, reading of reviews, saving favorites, and finally sharing in the vibrant community of food enthusiasts.]*

### Application Use Cases and/or Examples

![User case Diagram](items/uml_Diagram/UserCase.png)<br>

*Jay is looking for a new Chinese restaurant in his vicinity to try for dinner.*

*Jay is looking for a nice restaurant in his vicinity to try for dinner.*

1. *Jay opens the app and goes to the home screen, which has a input window above the page to type in and two button to filter.*
  
2. *He types "QT" in the search input box and views the results returned. Suddenly, he thought of a amazing restaurant, but he didn't remember the precise name, he typed in some character in memory which is very similar with the final result and he still can get the restaurant he want.*
  
3. *Then, he can choose to display the result in price order or rate order, or he can just reallocate the result according to types.*
  
4. *He finds the address of the restaurant he searched is too far to go, and then he want to check if there is any restaurant nearby.*
  
5. *So, he clicks the map fragment and he see the his location and all restaurant nearby, he can click any of red location icon displayed on the map and he can get the details of it, such as whole picture, rate, and precise address.*
  
6. *He chose a restaurant quickly and was eager to dine at this restaurant and shared his experience by posting his review. So, he want to chat his friend Mark, he jumped in the chat page and click Mark's column send his opinon about the restaurant.*
  
7. *His friend Mark used the application as well and read Jay's messages, then he wanted to go to that same restaurant based on his friend Jay's recommendation.*
  
8. *Later on, Mark chated Jay where he can find all the restaurants, because he want to collect some sepcial resetaurants in his list. Jay told him that he can click the item fragment and scroll down to check all the restaurants in this app, when scrolling to the bottom, just click the "load more data" to keep finding, and in the process in his travel, he can click the yellow star on the right-top corner in the restaurant he interests in to add the restaurant to his like list.*
  
9. *According to Jay's suggestions, Mark find he can click every single restaurant and subimt his comments and also check other users' comment to decide collect it or not.*
  
10. *Finally, he can check his collection in "Me" fragment and look for details about every restaurant he collected and group them according to the types. When he don't want use this app anymore he can just log out and exit.*
  

*Targets Users: Food enthusiasts, travelers, and anyone looking to discover new dining options*

- *Users can search restaurant based on their preferences and dietary needs.*
  
- *Users can search for restaurants nearby.*
  
- *Users can add restaurant to likelist and check every restaurant's details and other users' comments.*
  
- *Users can chat with other users about their opinon.*
  
- *Users can manage his/her own likelist and group them by types.*
  

<hr>

### Application UML

[Whole ClassDiagram](items/uml_Diagram/classDiagram.svg)<br>
<hr>
 DAO ClassDiagram: <br>
![DAO ClassDiagram](items/uml_Diagram/daouml.png)<br>
 DataStructure ClassDiagram: <br>
![DataStructure ClassDiagram](items/uml_Diagram/dataStructure.png)<br>
 Factory ClassDiagram: <br>
![Factory ClassDiagram](items/uml_Diagram/factoryUml.png)<br>
 Iterator ClassDiagram: <br>
![Iterator ClassDiagram](items/uml_Diagram/IteratorUml.png)<br>
 Observer ClassDiagram: <br>
![Observer ClassDiagram](items/uml_Diagram/observerUml.png)<br>
<hr>

## Code Design and Decisions

### Data Structures

*We used the following data structures in our project:*

1. *AvlTree*
   * ***Objective**: Used for storing restaurant data in a balanced search tree for the search feature. The AVL tree ensures efficient lookups, insertions, and deletions, enabling the application to quickly retrieve restaurant information based on user queries.*
   * **Code Locations**: Defined in [AvlTree.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/dataStructure/AvlTree.java?ref_type=heads), and initialized in [AvlTreeManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/dataStructure/AvlTreeManager.java?ref_type=heads).
   * *Reasons:*
     * The AVL tree is self-balancing, ensuring a time complexity of O(log n) for insertions, deletions, and lookups. This makes it more efficient than using an unsorted array or list when handling a large dataset of restaurants.
     * AVL trees are ideal for the restaurant search feature because the balanced nature ensures that no matter how large the dataset grows, search performance remains optimal.
     * We don’t need to access restaurants by index, which would make an array-based structure less suitable. Instead, the tree structure allows for quick retrieval based on comparisons (e.g., restaurant names or locations).
     * For restaurant queries, the tree’s ordering and balancing help provide both exact and suggested results based on user input, particularly when implementing fuzzy matching.
     * In the implementation AvlTree class is using generic type, so it can be used to store any type of data, expanding the code's reusability.

2. *ArrayList*

   * ***Objective**: Used for storing the restaurants that user liked and grouped these liked restaurants, when users like or unlike restaurants, the related list can update in time, and used to adapt ListView*
   * **Code Locations:**
     * Defined in [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads), this class extends to ArrayList, and override the addMethod and removeMethod ([line 71 - 92](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads#L71-92)) to adapt the Observer pattern; processed in [ItemListAdapter.java line 99 - 117](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/ItemListAdapter.java?ref_type=heads#L99-117) to add / remove restaurant object.
     * Defined in [ItemFragment.java - resList](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L46) to store the restaurants displayed in the 'item' list
     * Defined in [MeFragment.java - filterRes](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L71) to store the restaurants filtered by different type
   * *Reasons*: 
     * ArrayList can dynamically grow, it won't restrict the number of restaurants that user like.
     * ArrayList is sorted in the order in which the elements were added
     * The faster query speed of ArrayList can help users better group their favorite restaurants.

3. *Pair*

   * ***Objective**:  
   * **Code Locations**:
   



4. *List*

   * ***Objective**:
   * **Code Locations**:


5. *HashMap*

   * ***Objective**: Used for caching lists of restaurant data based on location. The key is a location identifier, which is calculated from the latitude and longitude of the restaurant's location, and the value is a list of restaurants associated with marker options.
   * **Code Locations**: 



<hr>


### Design Patterns

1. *Data Access Object Pattern(DAO)*
   * *Objective: used for storing user's information for [LogIn] feature and initialize restaurants data for [LoadShowData] feature.*
   * *Code Locations: defined in [ItemDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDao.java?ref_type=heads), [UserDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDao.java?ref_type=heads), [ItemDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDao.java?ref_type=heads) , [UserDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDao.java?ref_type=heads); processed in ItemDao - [MeFragment.java line 76 - 77](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L76-77), UserDao - [LoginActivity method checkUser](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads#L118-140) and [line 50 - 51](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads#L50-51)
   * *Reasons:*
     *  Hide details of the data storage and the way to access to database
     *  DAO can centralize the data access logic of the application to simplify business logic and facilitate data operations.
     *  When need to change the data source or modify the data access logic, we can only work on the data layer and do not affect other layers.


2. *Singleton Pattern*

   * *Objective: make sure there is only one instance of LikeRestaurant and User to provide a global access point to access that instance. LikeRestaurant used to store user's choice on 'Home' page or 'Item' page, and display on 'Me' page 'My Favorite' section; User used to store the name of login user and display on 'Me' page.*

   * *Code Locations: *

     * defined in [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads): processed using [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads#L30-32)
     * defined in [User.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/User.java?ref_type=heads); processed using  [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/entity/User.java?ref_type=heads)
     * defined in [AvlTreeManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTree.java?ref_type=heads); processed using [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTreeManager.java#L18)
     * defined in [MapRestaurantCache.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/cache/MapRestaurantCache.java?ref_type=heads); processed using [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/cache/MapRestaurantCache.java?ref_type=heads#L23-28)
     * defined in [UserCache.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/cache/UserCache.java?ref_type=heads); processed using [getInstance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/cache/UserCache.java?ref_type=heads#L16-21)
   
   * *Reasons:*

     * Only one instance in memory, reducing memory overhead
     * Provide a global access point for easy access to instances, avoiding the problem of repeatedly creating instances in different places.
     * Data can be easily shared between different objects

3. *Iterator Pattern*
   * *Objective: used for implementing paging function and optimizing loading datas for [LoadShowData] feature.*
   * Code Locations: 
     * Collection: [Container.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/Container.java?ref_type=heads)
     * Concrete collection: [RestaurantRepository.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/RestaurantRepository.java?ref_type=heads)
     * Concrete interator: [RestaurantIterator](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/RestaurantRepository.java?ref_type=heads#L36-70) (inner class)
     * Implement in: class [ItemFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads): [line 89 - 110](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L89-110)  with method [loadMoreData](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L144-150)
   * *Reasons:*
     * Simplify the aggregation class, the class does not need to care about the traversal logic.
     * Implemented paging functionality to speed up data loading


4. *Observer Pattern*
   * *Objective: used for realizing the grouping of restaurant data and real-time data update and display, for [Interact-Follow] feature*
   * Code Locations:  
     * Subject: class: [Subject.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/Subject.java?ref_type=heads)
     * Concrete Subject: [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads): [line 21 - 66](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads#L41-92)
     * Observer: [LikeRestaurantObserver.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurantObserver.java?ref_type=heads)
     * Concrete Observer: [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads) implement observer, but implemented by [filterRes](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L71)  with methods in [line 112 - 144](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L112-144)
   * Reasons:
     * Keep low coupling and high collaboration between objects
     * Ensure that the status of `filterRes` of different types can be updated synchronously with `likeRestaurant`


5. Factory Pattern

   * *Objective: used for .*

   * Code Locations: defined in [Class Factory](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/CommentFactory.java?ref_type=heads), [CommentItem](),[ContentInComment](),[UsernameInComment](); processed using Method [CommentActivity]()
   * Reasons:
       * The programmer who calls the comment object only needs to know whether he needs to call username or comment to create different objects in the comment.
       * High scalability. If someone need to add a new comment object, he/she only need to extend a factory class. 
       * The specific implementation of the comment is shielded, and the developer who calls the comment object only cares about the interface he needs.

<hr>


### Parser

### <u>Tokenizers and Parsers</u>

**Tokenizer (`Tokenizer` Class):**

- **Definition:** Defined in [Tokenizer.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Tokenizer.java?ref_type=heads)
- **Purpose:** Breaks down input queries into individual tokens based on whitespace.
- **Usage Scenario:** When a user inputs a query or command, the tokenizer processes the raw string to create a manageable list of tokens for further processing.

**Parser (`Parser` Class):**

- **Definition:** Defined in [Parser.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Parser.java?ref_type=heads)
- **Purpose:** Validates and corrects tokens by comparing them against a list of predefined valid tokens.
- **Usage Scenario:** After tokenization, the parser ensures that each token is recognized and corrects any discrepancies, such as typographical errors, before the tokens are used in the application’s logic.
### <u>Grammar(s)</u>

The parser's primary function is to validate and correct tokens by comparing them against this list using the Levenshtein distance algorithm.
The implementation of Levenshtein distance algorithm is in [levenshteinDistance()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Parser.java#L78)

The Levenshtein distance algorithm calculates the minimum number of single-character edits (insertions, deletions, or substitutions) required to change one string into another. When the parser reads a token from the token list generated with the tokenizer, it corrects any misspelled tokens by finding the closest valid token.

The parser operates based on a predefined list of **valid tokens** which are imported from item names imported from Firebase. Implementation is at [HomeFragment.getValidTokens()](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/bafbefbb0bf613b275a63570b186f2b5acb8af6e/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/HomeFragment.java#L236)


Production Rules:

```
<Sentence> ::= <Token>+
<Token> ::= <ValidToken>
```

**Advantages of This Design:**

1. Error Correction: The parser can correct user input errors, improving the user experience by providing more accurate search results.
2. Efficiency: The use of the Levenshtein distance algorithm ensures that the closest valid token is found efficiently, even for large lists of valid tokens.
3. Flexibility: The parser can handle a wide range of user inputs and correct them to match the valid tokens, making the application more robust.
4. Reusability: The Parser class can be reused in different parts of the application where input validation and correction are needed.
5. Maintainability: The clear separation of the parsing logic and the Levenshtein distance calculation makes the code easier to maintain and extend

<hr>


## Implemented Features

### Basic Features

1. `[LogIn]` The app must support user login functionality. User sign-up is not required. (easy)

      * Code: [LoginActivity.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads), [UserDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDao.java?ref_type=heads), [UserDaoImpl.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDaoImpl.java?ref_type=heads), [LoginCallback.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/util/LoginCallback.java?ref_type=heads)
      * Description of feature: User can use the fixed account to login <br>
      * Description of your implementation: 
        * Store the user's login information (username and password) in [Firestore database](https://console.firebase.google.com/project/smart-city-restaurant/firestore/databases/-default-/data/~2Fusers~2Fcomp2100) 
        * The login logic implemented in [LoginActivity.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDaoImpl.java?ref_type=heads)
        * When user click the login button, the app collects the entered username and password, calls [loginMethod](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads#L77-90) to check empty input
        * If it passes the empty judgment, calls [checkUserMethd in LoginActivity](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads#L118-140) and instantiates the [UserDao](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDao.java?ref_type=heads)
        * Then calls [checkUserMethod in UserDao](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/UserDao.java?ref_type=heads#L17) to compare and verify the information stored in database
        * Since Firebase queries are asynchronous, the query results are processed through callback functions [onCallback in LoginCallback](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/util/LoginCallback.java?ref_type=heads).
        * If the username and password are correct, user can log in normally. Otherwise, user cannot log in. <br>

2. `[DataFiles]` The app must use a data set (which you may create) where each entry represents a meaningful piece of information relevant to the app. The data set must be represented and stored in a structured format as taught in the course. It must contain at least 2,500 valid instances. (easy)

   * Code to the Data File: [Data set](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/assets/RES_dataSet.json?ref_type=heads)
   * Link to the Firebase repo: <a href="[smart-city-restaurant - Realtime Database - 数据 - Firebase 控制台 (google.com)](https://console.firebase.google.com/project/smart-city-restaurant/database/smart-city-restaurant-default-rtdb/data/~2Frestaurants?hl=zh-cn)">firebase</a>
   * Description of your implementation:
   
      I obtained the official open map API interface of Google from the Google Cloud Console, and obtained the restaurant data we needed from Google Maps through the Google API interface. Then I wrote a script program in Python to crawl data through the API interface. This script uses a simple grid method to generate search locations from several major cities in Australia. Each city has about 10 to 30 search locations (depending on the size of the city), with a search radius of 1,000 meters. The search keywords are restaurant, cafe, bar, and the information obtained includes name, image URL, rating, address, latitude and longitude, price level and restaurant category. Finally, the results are saved in JSON format.

3. `[LoadShowData]` The app must load and display data instances from the data set. Data must be retrieved from either a local file (e.g., JSON, XML) or Firebase. (easy)

      * Code: [ItemListAdapter.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/ItemListAdapter.java?ref_type=heads), [ItemFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads), [RestaurantRepository.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/RestaurantRepository.java?ref_type=heads) ,  [ItemDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDao.java?ref_type=heads),  [ItemDaoImpl.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDaoImpl.java?ref_type=heads)<br>
      * Description of your implementation: 
        * We stored the restaurant data in [Realtime Database](https://console.firebase.google.com/project/smart-city-restaurant/database/smart-city-restaurant-default-rtdb/data/~2Frestaurants) because it works well with JSON-formatted data.
        * The basic logic implement in  [ItemFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads), when user jump to 'item' page, calls  [initiateDataMethod](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/ItemFragment.java?ref_type=heads#L119-133) to fetch the initial list of restaurants from a Firestore database using the [ItemDao.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dao/ItemDao.java?ref_type=heads) class.
        * To ensure loading speed, only 12 data are displayed per page. Users can click the 'load more data' button to load the next page.
        * Paging functionality is implemented using the Iterator pattern 
        * The  [RestaurantIterator](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/Iterator/RestaurantRepository.java?ref_type=heads#L36-70)  will be used to determine whether there is any data (hasNext). If so, the next method will be called and the data of the next page will be added to the display list.
        * Once the data is fetched, the UI is updated via the [ItemListAdapter.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/ItemListAdapter.java?ref_type=heads) and  display the restaurant data in a list format.<br>

4. `[DataStream]` The app must simulate user interactions through data streams. These data streams must be used to feed the app so that when a user is logged in (or enters a specific activity), the data is loaded at regular time intervals and the app is updated automatically.  (medium)

   * Code: [CommentActivity](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/activity/CommentActivity.java?ref_type=heads),[CommentAdapter](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/adapter/CommentAdapter.java?ref_type=heads),[CommentFactory](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/Factory/CommentFactory.java?ref_type=heads),[Comment](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/entity/Comment.java?ref_type=heads)
   * Description of feature:Users can click every single restaurant and jump to new page with details and comments. The comment can be generated by system automatically,and user can submit their own comments on it, it excatly simulate the datastream between the users and other users.<br>
   * Description of your implementation:First we need to set click listener on ever item showed in the list, and then we design the new page's [UI](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/res_comment.xml?ref_type=heads#L1) for comment and write a new class `comment` to represent the comments show under the restaurants with factory design pattern. Secondly, we design the activity and adapter for comment page to show the details of certain restaurant and generate the comment normally, we apply `thread` in it and set the time gap as 2~3 seconds. Finally, we designed a lot of contents and usernames for every comment and let them loaded in comment page successfully.<br>

5. `[Search]` The app must allow users to search for information. Based on the user's input, adhering to pre-defined grammar(s), a query processor must interpret the input and retrieve relevant information matching the user's query. The implementation of this functionality should align with the app’s theme. The application must incorporate a tokenizer and parser utilizing a formal grammar created specifically for this purpose. (medium)

6. `[UXUI]` The app must maintain a consistent design language throughout, including colors, fonts, and UI element styles, to provide a cohesive user experience. The app must also handle orientation changes (portrait to landscape and vice versa) gracefully, ensuring that the layout adjusts appropriately. (easy)

   - Code: [fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_home.xml?ref_type=heads),[fragment_map.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_map.xml?ref_type=heads),[fragment_me.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/fragment_me.xml?ref_type=heads),[comment_item.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout/comment_item.xml?ref_type=heads);layout(landscape):[fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/fragment_home.xml?ref_type=heads),[fragment_me.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/fragment_me.xml?ref_type=heads),[res_comment.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/res/layout-land/res_comment.xml?ref_type=heads).
   - Description of feature: The existing design is consistent in terms of style, font, color theme, and layout. It also supports the changes in screen orientation-smooth moving of layout for a good user experience.
   - Description of your implementation: We have used responsive layouts that can be achieved through the use of flexible containers; these will handle the change in screen orientation by reorienting the layout properly upon rotation and also maintain coherence in design and readability. 

7. `[UIFeedback]` The UI must provide clear and informative feedback for user actions, including error messages to guide users effectively. (easy)

   - Code: [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads)，[LoginActivity.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/dev/SmartCity/app/src/main/java/com/example/smartcity/frontend/activity/LoginActivity.java?ref_type=heads)
   - Description of feature: The app shows feedback for failed login attempts and also acknowledges a successful logout action.
   - Description of your implementation: On the login page, we validated the user's input against the stored credentials, displaying "Wrong username or password" for incorrect entries. Upon logout, a toast message "You have logged out" appears, confirming the action and redirecting the user back to the login page.
   <br>

### Custom Features

Feature Category: Search-related features <br>

  1. `[Search-Invalid]` The search functionality must not only provide results for valid search queries (extension of the basic **[Search]** feature) but also process and correctly handle partially invalid search queries, returning meaningful results. Refer to the [Feature Request Example](#feature-request-example) for further explanation of this feature. (medium)

     * Code: [Parser.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Parser.java?ref_type=heads), [HomeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/HomeFragment.java?ref_type=heads)
      
     * Description of feature: When a user enters a partially invalid search query, the search functionality should correct the query and return relevant results. For example, if a user types "restauran" instead of "restaurant," the search should return results containing the term "restaurant." 

     * Description of your implementation: The search functionality has been extended to handle partially invalid search queries. The parser uses the Levenshtein distance algorithm to correct misspelled tokens and return the closest valid token. For example, if a user types "restauran" instead of "restaurant," the parser will correct the query and return the relevant results containing the term "restaurant." cause "restaurant" is the minimum distance to "restauran" in the valid tokens list.

     <br>

  2. `[Search-Filter]` The app must provide functionality to sort and filter a list of items returned from searches using appropriate UI components. (easy)

     * Code: [HomeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/HomeFragment.java?ref_type=heads), [ItemListAdapter.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/ItemListAdapter.java?ref_type=heads), [RestaurantManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/manager/RestaurantManager.java?ref_type=heads)
      
     * Description of feature: Users can sort and filter the list of items returned from searches based on price and rating. The UI should include appropriate components for sorting and filtering, such as dropdown menus or buttons.

     * Description of your implementation: The search functionality has been extended to include sorting and filtering options. Users can sort the list of items by price or rating, and filter different restaurant types. By default the list of results are sorted by name and all types of restaurants are listed. When clicking spinner, the list could be sorted by choosing different restaurant types, and sort by price or rating, from high to low or low to high. This is implemented by adding the sequence of the list in [RestaurantManager.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/manager/RestaurantManager.java?ref_type=heads#L23-25) and [HomeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/HomeFragment.java?ref_type=heads#L236-238). The UI components are implemented in [fragment_home.xml](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/res/layout/fragment_home.xml?ref_type=heads).


Feature Category: Greater Data Usage, Handling and Sophistication <br>

   3. `[Data-GPS]` The app must utilize GPS information based on location data. Hint: see the demo presented by our tutors on ECHO360. (easy). 

      * Code: [MapFragment.java]()

      * Description of your implementation: 
        * Implemented GPS functionality using the Google Maps API to display nearby restaurants based on the user's current location.
        * Loaded restaurant data from a Firebase database and marked them on the map using custom markers, allowing users to tap on markers for more information.

Feature Category: Peer to Peer Messaging <br>


   4. `[P2P-DM]` The app must provide users with the ability to send direct, private messages to each other. (hard). 

   * Code: [ChatFragment.java](), [ChatActivity.java](), [SearchUserActivity.java]()

   * Description of your implementation: 
        * Developed a peer-to-peer messaging system that allows users to send and receive direct messages.
        * Utilized Firebase Firestore for real-time data synchronization, enabling messages to be sent instantly and visible to both sender and receiver.
        * Created user search functionality that allows users to find other users by name, facilitating the initiation of chats.
        * Implemented RecyclerViews to display recent chat windows and chat messages, enhancing user experience through efficient data handling and presentation.

Feature Category: User Interactivity <br>

   5. `[Interact-Follow]` The app must provide the ability to follow, save or collect items. There must be a section that displays all items followed, saved or collected by a user, with items grouped and ordered. This information should be stored in-memory. (hard). 

   * Code:  [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads),  [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads),  [Subject.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/Subject.java?ref_type=heads),  [LikeRestaurantObserver.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurantObserver.java?ref_type=heads),  [ItemListAdapter.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/adapter/ItemListAdapter.java?ref_type=heads)

   * Description of your implementation: 
     * A like button is added for each restaurant. Users can click the button to add the restaurant to 'My Favorite'.
     * Use a global variable [LikeRestaurant.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/observer/LikeRestaurant.java?ref_type=heads) as a subject to store the restaurants liked by user
     * The list of these restaurants saved in 'My Favorite' section on 'me' page ( [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads)). 
     * The list of like restaurants is ordered by adding time, and can be grouped by type
     * When the user unlikes a restaurant in the 'My Favorite' section, the [likeRes](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L69) storing the data will be updated and notify [MeFragment.java](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads) as the observer, which will call the update method to update [filterRes](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/frontend/fragment/MeFragment.java?ref_type=heads#L71), thus achieving real-time updates of filterRes and the list.

<hr>


### Surprise Feature

*Instructions:*

- If implemented, explain how your solution addresses the task (any detail requirements will be released with the surprise feature specifications).

- (i) identify **at least one existing** code component that could be replaced by a design pattern—list all relevant git commits, files and line numbers (and provide links) from **before 10 October**;

  - Relevant git commits:  [Rebuild item_list layout to fit favorite function (22e7bba3) · Commits · Yuheng Li / gp-24s2 · GitLab (anu.edu.au)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/commit/22e7bba3ce999c8ebddd5766951aa77f099758a8) , [Implement favorite basic function (7b26f2d9) · Commits · Yuheng Li / gp-24s2 · GitLab (anu.edu.au)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/commit/7b26f2d986c1976984fd971f42edb77b6064faa5)  (1 October)
  - Related class: [LikeRestaurant (line 1- line 14)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/7b26f2d986c1976984fd971f42edb77b6064faa5/SmartCity/app/src/main/java/com/example/smartcity/entity/LikeRestaurant.java#L1-14) , [MeFragment (line 32 - line 34)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/7b26f2d986c1976984fd971f42edb77b6064faa5/SmartCity/app/src/main/java/com/example/smartcity/fragment/MeFragment.java#L32-34) .

- (ii) correct **at least one existing** of the implementation issues identified in (i)—list all relevant git commits, files and line numbers (and provide links) from **on or after 10 October**, and explain why the previous solution was not suitable and how you solved the issue;

  - Written approval of this case: https://edstem.org/au/courses/17641/discussion/2185403?comment=5149239
  - Relevant git commits: [Optimise 'Me' page my favorite part (1a237d78) · Commits · Yuheng Li / gp-24s2 · GitLab (anu.edu.au)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/commit/1a237d78a22835ea8d949a033561659247e75236), [Fix the wrong display of restaurant type (ae7e3ec9) · Commits · Yuheng Li / gp-24s2 · GitLab (anu.edu.au)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/commit/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6)

  - Relevant files:

    - Changed: [MeFragment.java (line 56 - line 60)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6/SmartCity/app/src/main/java/com/example/smartcity/fragment/MeFragment.java#L56-60)

    - Expand: [LikeRestaurant (line 10 - line 65)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6/SmartCity/app/src/main/java/com/example/smartcity/observer/LikeRestaurant.java#L10-65), [LikeRestaurantObserver (line 1 - line 6)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6/SmartCity/app/src/main/java/com/example/smartcity/observer/LikeRestaurantObserver.java#L1-6), [Subject (line1 - line9)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6/SmartCity/app/src/main/java/com/example/smartcity/observer/Subject.java#L1-9), [MeFragment (line 64 - line 82)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6/SmartCity/app/src/main/java/com/example/smartcity/fragment/MeFragment.java#L64-82), [MeFragment (line 94 - line118)](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/ae7e3ec9494fa546f2377743d6e8eb75526cf7b6/SmartCity/app/src/main/java/com/example/smartcity/fragment/MeFragment.java#L94-118)

    - Why the previous solution was not suitable: 

      In the old version, if the user click the "like" button to like  restaurant on the item page, then it appeared in the "My Favorites" section of the me page. If the user clicked on the "like" button again-to unlike-the restaurant instantly disappeared from the favorites list. I did this by using the Singleton pattern to create the class `LikeRestaurant`, which extended the `ArrayList<Restaurant>` and acted as a global variable, which stored the user's selections in memory. Then, the `ItemAdapter` was set to listen for that instance; thus, when the user liked a restaurant on an item page, it showed up in "My Favorites." Similarly, unliking it immediately removed it from the list.

      However, when the 'grouped' feature was introduced, the previous code couldn't support real-time updates when restaurants were grouped by type. ⁤⁤This is because `ItemAdapter` only listened to `LikeRestaurant`, while the grouping functionality used another list, `filterList` (used to store the filtered restaurants). ⁤⁤When the user grouped restaurants in "My Favorites," `filterList` was updated based on the types in `LikeRestaurant`, but the display didn't update immediately when a restaurant was unliked. ⁤⁤Even though the restaurant was removed from `LikeRestaurant`, it still persisted in `filterList` (The 'like' button is canceled display), since `ItemAdapter` wasn't listening to it. 

    - How to solve the issue: 

      The essence here is ensuring that `filterList` updates in real-time whenever `likeRestaurant` is modified. This scenario is a perfect fit for the Observer pattern. In this case, `likeRestaurant` would act as the subject, and `MeFragment` (though implemented in `filterList`) would be the observer. When the state of `likeRestaurant` changesᅳsuch as when a user likes or unlikes a restaurantᅳthe add() or remove() methods are triggered, and the observer is notified. This, in turn, calls `filterRestaurantsByType` to update the state of `filterList`. By applying the Observer pattern, when user unlike the restaurant on 'Me' page, the state of `likeRestaurant` changed, and notified current `filterList`, the update the state of `filterList`, thus implemented the real-time updates of the list.

- (iii) select a software license and explain why you chose this one (4 sentences maximum);<br>
 **The license we choose:** MIT License<br>
 **The reason:** We choose the MIT LICENSE since it has wide usage, allowing modification and distribution, and the source code of an app remains open-source. It highly encourages collaboration, hence further development. Secondly, it limits liability and warranty, protecting the developers(us). Since the app will likely evolve and will be integrated in many other systems, the MIT License makes this flexible.

- (iv) identify and explain **at least one** ethical issue arising from the development or deployment of your app (6 sentences maximum)—you may refer to the IEEE Computer Society Code of Ethics for ideas about potential ethical considerations.<br>
**The ethical issues we may need to attention:** User privacy<br>
**The reason:** One ethical issue in the development or deployment of the app is user privacy, particularly in how location and personal data are collected and stored. If users' data, such as their search history or chat list, is not properly secured or anonymized, it could be misused, leading to privacy violations. According to the IEEE Code of Ethics, developers have a duty to protect users' data and ensure that their systems do not cause harm. It is crucial to inform users about how their data is used and to gain proper consent. Failure to do so would undermine trust and could lead to ethical breaches.

<br> <hr>

## Testing Summary

1. Tests for Search & Data Structure

    Since the search feature is connected to the data structure, we have tested them together. We have created a series of test cases to ensure that the search functionality works as expected and that the data structure is correctly implemented. The tests include:

   - Code: [ParserTest Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/test/java/com/example/smartcity/backend/dataStructure/ParserTest.java) for the [Parser Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Parser.java)<br>
   [TokenizerTest Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/test/java/com/example/smartcity/backend/dataStructure/TokenizerTest.java) for the [Tokenizer Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/Tokenizer.java)<br>
   [AvlTreeTest Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/test/java/com/example/smartcity/backend/dataStructure/AvlTreeTest.java) for the [AvlTree Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/dataStructure/AvlTree.java)<br>
   [AvlTreManager Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/test/java/com/example/smartcity/backend/manager/AvlTreeManagerTest.java) for the [AvlTreeManager Class](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/SmartCity/app/src/main/java/com/example/smartcity/backend/manager/AvlTreeManager.java)<br>
   - *Number of test cases: 13
   - *Code coverage: 100% of Classes, 92% of Methods, 94% of Lines and 88% of Branches covered in Data Structure related classes*
   <img src="media/report/codecoverage_test.png">
   - *Types of tests created and descriptions:*
     - AvlTreeManagerTest
         - testSingletonInstance: Verifies that the AvlTreeManager class correctly implements the Singleton pattern by ensuring that only one instance of the AVL tree is created.
         - testAvlTreeFunctionality: Tests the basic functionality of the AVL tree managed by AvlTreeManager, including insertion and exact search operations.
      
     - TokenizerTest
         - testTokenize: Ensures that the Tokenizer class correctly breaks down an input query into individual tokens based on whitespace.
      
     - ParserTest
         - testParse: Validates that the Parser class correctly parses and corrects tokens using a predefined list of valid tokens, ensuring that misspelled tokens are corrected.
      
     - AvlTreeTest
         - testInsert: Verifies that the AVL tree correctly inserts new nodes and updates the node count.
         - testSearchExact: Ensures that the AVL tree can find an exact match for a given restaurant name.
         - testSearchExactNotFound: Confirms that the AVL tree returns null when an exact match is not found.
         - testSearchByContains: Tests the AVL tree's ability to find nodes that contain a given substring.
         - testToList: Verifies that the AVL tree can convert its nodes to a list in the correct order.
         - testCountNodes: Ensures that the AVL tree correctly counts the number of nodes.
         - testBalance: Confirms that the AVL tree remains balanced after multiple insertions.
         - testRotateRight: Tests the AVL tree's right rotation operation to ensure it is performed correctly.
         - testHeight: Verifies that the height of the AVL tree is correctly calculated.
    

2. Tests for Iterator

    - Code: [IteraotrTest Class]() for the [RestaurantRepository Class]()
    - *Number of test cases: 2*
    - *Code coverage: *
    - *Types of tests created and descriptions:*
      1. testLoadPageData():
        - Simulate an AVLTree that inserts data
        - Validate correct loading of paginated data from the AVL tree.
        - Verify that the iterator can correctly load the paginated data
        - Ensure that each page contains the correct number (12)
        - Ensure the next page with data can load successfully
        
      2. testLoadExcessiveData():
        - Ensure that the iterator correctly identifies when there is no more data to return.
...

<br> <hr>

## Summary of Known Errors and Bugs

1. *Bug 1:*

   - Description: When users are in the process of searching for users or chatting with other users, pressing the phone's built-in back navigation key causes the application to crash or logs out the current user.
   - Steps to Reproduce:
       - Open the application.
       - Navigate to the user search or chat feature.
       - Press the back navigation key on the phone.

2. *Bug 2:*

   - Description: When the emulator is launched for the first time and the map interface is accessed, the map displays at the default location (Los Angeles) instead of the set current location (ANU's CSIT building), despite the emulator's default location being configured correctly. Users need to manually click the location button to update to the correct position.
   - Steps to Reproduce:
       - Launch the emulator.
       - Open the application.
       - Navigate to the map feature.
       - Observe that the map shows the default location instead of the configured location.

3. *Bug 3:*

    - Description: After the map is loaded for the first time, clicking on a restaurant marker displays the info window with the restaurant details. However, when the info window is clicked again, it turns into a blank window. On the third click, the info window returns to displaying the restaurant information again. This inconsistent behavior can confuse users.
    - Steps to Reproduce:
       - Launch the emulator and open the application.
       - Navigate to the map feature and wait for the map to load.
       - Click on a restaurant marker to open the info window, which displays the restaurant details.
       - Click on the info window again and observe that it changes to a blank window.
       - Click on the blank info window once more, and the restaurant information is displayed again.


<br> <hr>

## Team Management

### Meeting Minutes

  - *[Team Meeting 1](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-one.md?ref_type=heads) (Teaching Break, 2024-09-10)*
  - *[Team Meeting 2](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-two.md?ref_type=heads) (Week 7, 2024-09-17)*
  - *[Team Meeting 3](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-three.md?ref_type=heads) (Week 8, 2024-09-28)*
  - *[Team Meeting 4](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-four.md?ref_type=heads) (Week 9, 2024-10-04)*
  - *[Team Meeting 5](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-five.md?ref_type=heads) (Week 10, 2024-10-10)*
  - *[Team Meeting 6](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-six.md?ref_type=heads) (Week 11, 2024-10-17)*

<hr>

### Conflict Resolution Protocol

*As listed in the [first team meeting](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/items/team-meeting-record-one.md?ref_type=heads), the following protocol will be used to resolve conflicts:*

* Interpersonal Conflict Resolution Protocols
 
    * Discuss with the relevant group member and/or a neutral group member, and attempt to find a solution.
    * If an internal solution isn't found, discuss potential solutions with the group, and attempt to find a solution as a group.
    * If a resolution isn't found within two/three days, or there is clearly no prospect of a resolution, discuss with the lab tutor and/or the teaching team.


* Work-Related Conflic Resolution Protocols

    * A group member will discuss the situation with the affected member and attempt to find a solution.
    * If a quick solution isn't found, the group will meet and attempt to find a solution that helps the affected member without unreasonably affecting the other group members.
