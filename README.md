# Superheroes

This practice codelab was a good review of the creation of a compose screen from scratch.

I deliberately deferred looking at the solution until I was done.

I did make the screen look like the wireframe.

The major difference between my practice code and the solution was what scope to hoist and to what level.

Here are points I learned.

- The Surface in onCreate of MainActivity should configure fillMaxSize().
- Set the background color of the Surface with the background I created with Material Design Builder.
- Do create a SuperheroesApp Composable function in MainActivity.
- Encapsulate the Scaffold in SuperheroesApp; set the TopAppBar here
- Call the data source from SuperheroesApp; hoist the data source here to keep the screen Composable declarative and UI-only
- Pass the content padding of scaffold and heroes data list to the HeroItems Composable function.
- Hoist the hero item padding to the items iterator of LazyColumn; use the horizontal/vertical option for padding.
- Set the Row height in the Card using sizeIn extension function.
- Configure the weight of 1f on the Column in the Row so it expands to the right.
- Place a Spacer between the description Column and Image to maintain a margin.
- Configure the rounded corners with the clip extension function and set image size on the Box that contains the image.

