# gilded-rose-mob

## Collaboration Tools
1. Slack - Our team used this tool to exchange schedules and plan the project.
2. join.me - We used this program to meet and record our mob programming online.

## Code Smells
1. "for" Loop 
    This necessitated a redeclaration of the item declaration with iteration.
    We solved this "smell" by changing the loop to a "foreach".
2. Item names are hardcoded.
    Each item name was hardcoded and repeated through the code, creating
    a higher probability of mistake. We solved this "smell" by adding
    variables to hold the item names.
3. Nested if/else Statements
    These statements were hard to read, and made it hard to update the code.
    We solved this "smell" by implementing a switch statement that applied
    the correct logic for each "type" of item.
4. Redundant Code
    This produced a lot of unnecessary code that was difficult to read and update.
    We solved this "smell" by extrapolating duplicate logic to an outside
    method that could be called when needed.
5. No Code Comments
    The lack of comments in the original code made it difficult to read
    and locate the logic that was being implemented. We solved this "smell"
    by adding comments that assisted future developers in reading and
    understanding our code.