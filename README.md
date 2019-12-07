[network]: http://i.imgur.com/hcv1gI5.png "Network Block Diagram"
[home]: http://i.imgur.com/FZcOZl9.png "Splash Screen, Cutters, DesignsSplash Screen, Cutters, Designs"
[community]: http://i.imgur.com/JEk9DaU.png "Public Designs, My Designs, Nav Drawer"
[signin]: http://i.imgur.com/dndRXRJ.png "Add new cutter, Sign in, Sign Up"
[cutting]: http://i.imgur.com/9Y6X61W.png "Modify, Sending, Cutting"
## General
I'm just throwing this up really quickly in case someone wants to get started on the app, and android is the easiest way to get developing if we want to have a good UI, later on we can port it over to IOS, but we would need a developer account to start testing it.

##Design Ideas
The overall design philosophy is to make this as easy to use as possible. 
In order to achieve this we have to seperate our userbase into two categories. We have the CAD savants who love making their own designs, then we have the gentlemen who just want to cut stuff and be on their merry way. We can cater to both if we design the app cleverly. 

###Core Network
Starting off, we want there to be networking. If we want to cater to both audiences there HAS to be networking. It's not difficult either since in modern age we have libraries and software that'll do all this for you and for free. 
Here is a general idea of how the network communication would look:

![Network Block Digram][network]

The user could potentiall have multiple mills, especially if they're operating in a large shop. So each mill would have its own IP determined by the local router which (if the phone is on the same network) would allow the phone to connect using that address. Otherwise it'd need port forwarding over an open network to connect across the internet (Which we can TOTALLY do, but I'll get into that bit later). 

Next the phone would connect to the mill over the same network or over the internet. The phone would come prebundled with basic design patterns (squares, circles, etc, etc) that the user could modify slightly before sending it to the mill. Otherwise they can download public designs made by the community or download their own made on the computer.

They could move the design over USB to the phone or download with no account required. Signing in will be **entirely** optional; however, if the user wants to upload their design to the community for the public to use then they can. All of this will happen on a web application and **not** on the phone. The reason for this is because we want to create a separation of creators and users. All of the tools required to create designs would be cumbersome on the phone and just clutter up the thing for people who don't care about it in the first place. So, **all** designing will be done on the computer. Modifications such as aspect ratio, size, etc can be changed on the phone but no new design creation. More on that later.

This design should keep usage as easy as possible while still allowing community creators the potential to create their designs. 

###User Interface
In Android development, we generally want to follow the [material design guidelines](https://material.io/guidelines/) as close as possible. This will provide a common look and feel for the app so the user doesn't have to go searching for whatever they're looking for. This design is used in the majority of Android apps and therefore should be intuitive enough for less savvy users. 

![Splash Screen, Cutters, Designs][home]

Most apps are prefaced with a splash screen which gives the user something to look at when it's first loading. Nothing much to really talk about here other than whatever we should make the logo look like. There might be an onboarding process before this which does an initial setup for someone who has never used the app before. It would basically just let them setup their first mill or walk them through how to do it, etc, etc. 

Once the app starts, it immediately takes you to your list of cutters. Here, tapping one of the cutters will take you to the designs page which contains all public designs and the designs which you've made on the computer. Otherwise, pressing the floating action button will let you add a new cutter to the list, which can be seen further down below. 

The designs here are only the designs which you've subscribed to. It saves a local copy of community designs on the phone so if the author changes his design, it won't affect your copy unless you choose to update to the newer design. You could also select one of the designs that came bundled with the app or one that you made yourself **on the computer which you uploaded**. 

![Public Designs, My Designs, Nav Drawer][community]

The community designs page and your designs can both be accessed from the navigation drawer by clicking the hamburger at the top left. Public designs are designs created by the community which can be upvoted or downvoted and filtered. Clicking a design will take you to an information page about it including its default dimensions, layers, etc. More on that down below. 

Your designs are either designs you made on the computer and uploaded to the cloud which is tied to your account or you uploaded over USB to your phone's local storage. There will be a floating action button here that will let you open SVG files from your phone. Tapping a design will let you manage it so you can change the aspect ratio, cutting layers, etc.

The navigation drawer is a common component in many apps. It essentially does what it says. It lets you navigate to things. 

![Add new cutter, Sign in, Sign Up][signin]

On the Cutters page when you click the floating action button it'll take you to this screen which will allow you to app a new cutter through an IP address or autodetect. The autodetect feature will prob each IP on the local area network for a specific handshake it expects from a cutter. If it's received, then it will autofill the information for you. 

**Signing up is entirely optional** Someone who never produces designs and just uses them will never have to sign up. However, if you do want to be a design creator we need to tie a name to it so you can update it and maybe build fame as an expert designer so people can follow your designs or something. Either way, only useful for savants. Not so much for bumblefucks

Signup follows suit. 

![Modify, Sending, Cutting][cutting]

When you go to print a design, you have the option to modify things like the aspect ratio, dimensions, and layers. Layering allows for the device to control how hard she chooches or if she just skips the line altogether. We don't expect crazy elaborate designs, so there probably won't be many layers. 

Sending the design to the cutter will take some time, so we'll give the user a nice little progress dialog and close it when they're done. Of course they got a cancel button if something changes. 

Once it's sent in the status bar of the phone you can see the ETA to completion. You'll also be able to tell the cutter to stop what it's doing if you like. There will probably be an "Oh Shit" button on the device somehwere, but that's on the hardware guys. 

##CNC Cutter Interface
The interface for the cutter would probably be a Spring or Node.js RESTFUL service with port 8080 open so that the app could probe the local area connection and get a response from all devices broadcasting on port 8080. Then, the device can send the design as a series of points as a JSON file to the rest API. From there it would communicate with whatever software the hardware guys are doing to make her chooch. 

The CNC itself would probablt have a super basic interface so that the user can connect it to the wifi and provide an "Oh Shit Stop" button. Nothing too fancy since all the fancy stuff is on the phone.

##Web Application
Not much design has been done here, but I imagine it'd be something pretty simple. Just gotta have an interface that let's people upload designs to the cloud and maybe view other designs. Since your account is connected already, you could save designs on the web app and they'd appear on your phone. 

For the backend database, Google recently released their [Firebase service](https://firebase.google.com/) which does a **TON** of this for **FREE**.
