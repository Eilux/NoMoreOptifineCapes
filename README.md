# No More Optifine Capes
This fabric mod prevents the game from displaying Optifine capes, it must be installed alongside [Optifabric](https://github.com/Chocohead/OptiFabric) but beyond that requires no special setup beyond that.

## How it works
This mod uses reflection to change some values inside the part of optifine responsible for fetching the cape texture, part of the process involves checking to make sure that the username is valid, what this does is it changes the pattern for a valid username to be a name with no characters, effectively removing them.

