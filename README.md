# prime-numbers-calculator

Service that executes prime number calculation between 1 to N.

# Request

Can only recieve calls made through gRPC


## Libraries used
The library used for rest communication between the apps was gRPC. By using that library it was possible to avoid some boilerplate code and also the way how the two apps interact with each other looks almost as a local object from the code perspective. 

## Next Improvements 
- Add clean architecture to the project (had some issues generating protobuff files when I tried to use that type of architecture) 
- external properties
