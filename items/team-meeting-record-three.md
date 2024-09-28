# Five-Coders Team Meeting

## Team Meeting #3 - Week 8, 28th, September, 2024 (14:00 - 16:00)
**Present:** 
Simon Liu, Shengzong Dai, Rongze Gao, Yuheng Li, Tianfa Zhu
<br>
**Absent:**
None
<br>
**Scribe:**
Simon Liu

## Agreed Procedure
Meeting Procedure:

- Each member will give an update on their progress (in future meetings), and discuss any issues or concerns.
- The floor will then be open for agenda items to be discussed, with the scribe mediating if necessary.
- Once all items and concerns are raised and addressed, the meeting will conclude, with the minutes available for review and edit on Gitlab.


## Agenda Items
| Number    |        Item |
|:---------:|:------------|
| 1 | Review of the Project |
| 2 | Data Arrangement |
| 3 | User Interaction |
| 4 | Search Tokenizer & Parser |
| 5 | Custom Features Discussion & Planning |

## Meeting Minutes
1. **Review of the Project**

    Currently the app could show a basic user interface with pre-defined data of the restaurant, as well as its detailed information. The user can also login with correct accounts and passwords. What we're looking for now is refine the app with basic features and expand to custom features.

2. **Data Arrangement** (Priority - High, Due date - 24th, September, 2024)

    - Currently we have more than 2500 instances of data.
    - However the attributes of data are displayed each line, making the total lines of data more than the IDE can display.
    - Solve Method: Rearrange the data and display each instance of data in a single line.
    - Assignee: [Yuheng Li](https://gitlab.cecs.anu.edu.au/u7810157)

2. **User Interaction** (Priority - Medium, Due Date - 5th, October, 2024)

    - Currently the app could show the information of each restaurant.
    - Next we want to implement the comments & posts features for user.
    - Assignee: [Shengzong Dai](https://gitlab.cecs.anu.edu.au/u7811526) & [Rongze Gao](https://gitlab.cecs.anu.edu.au/u7841935)

3. **Search Tokenizer & Parser** (Priority - High, Due Date - 5th, October, 2024)

    - Figure out how the search method would tokenize and parse the user input
    - Explain how the tokens would be used in tree data structures, so the search feature could be implemented.
    - Assignee: [Simon Liu](https://gitlab.cecs.anu.edu.au/u7761758)

4. **Custom Features Discussion & Planning** (Priority - Medium, Due Date - 7th, October, 2024)

    - [Search-Filter](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BSearch%2DInvalid%5D,this%20feature.%20(medium))    Considering implement filters when doing the search.
    - [UI-Layout](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BUI%2DLayout%5D,screen%20size.%20(easy)) Adjust user interface layout corresponding to the user's device or screen size.
    - [Data-GPS](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BData%2DGPS%5D%20The%20app%20must%20utilize%20GPS%20information%20based%20on%20location%20data.%20Hint%3A%20see%20the%20demo%20presented%20by%20our%20tutors%20on%20ECHO360.%20(easy)) The gps information is already stored 
    - [P2P-DM](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BP2P%2DDM%5D%20The%20app%20must%20provide%20users%20with%20the%20ability%20to%20send%20direct%2C%20private%20messages%20to%20each%20other.%20(hard)) If time allows, considering adding dm featuers in app, allowing users to send message to each other. (Could be hard, if time is limited might not add this feature, details discussed later)
    - [Interact-Follow](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BInteract%2DFollow%5D%20The%20app%20must%20provide%20the%20ability%20to%20follow%2C%20save%20or%20collect%20items.%20There%20must%20be%20a%20section%20that%20displays%20all%20items%20followed%2C%20saved%20or%20collected%20by%20a%20user%2C%20with%20items%20grouped%20and%20ordered.%20This%20information%20should%20be%20stored%20in%2Dmemory.%20(hard)) Add follow/like feature so that the user can add items into their favorite list. Also allow the favorite items listed in various ways.
    - [FB-Auth](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BFB%2DAuth%5D%20The%20app%20must%20use%20Firebase%20to%20implement%20user%20authentication%20and%20authorisation.%20(easy)) The app will use Firebase to implement user authentication and authorisation.
    - [Interact-Noti](https://gitlab.cecs.anu.edu.au/u7810157/gp-24s2/-/blob/main/gpSpec/2_Features.md?ref_type=heads#:~:text=%5BInteract%2DNoti%5D,immediate%20notifications.%20(medium)) App would send notifications based on user interactions.
 
### Next-Meeting Planning

    Meeting Three - Week 9 (Time TBD)
    Scribe - Simon Liu