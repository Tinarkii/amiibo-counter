# What is an Amiibo Counter
In The Legend of Zelda: Breath of the Wild (BOTW), it is possible to scan amiibo to receive item benefits in game. However, a single amiibo can only be scanned once per day. It is possible to circumvent this issue, as BOTW has a memory limit (in the form of a stack) to how many amiibo scans it will remember, being 100. This means that it is feasibly possible to rescan amiibo during the same day so long as you have 101 amiibo to scan.

The next issue, however is that while it is possible to do this with amiibo, it is very difficult, as one cannot easily keep track of what amiibo have been scanned and when. Thats where this comes in. With the amiibo counter, one can manually input what amiibo have been scanned, and the program will simulate the amiibo being devoted to stack memory in the game and (when enough amiibo have been scanned) will also notify you of when it has been freed.

# The Present
Right now this program fully functioning as a simulation of the memory stack and everything concerning it (tracking amiibo pushed out of memory, keeping track of those still in, and keeping track of those yet to be used). It is wholly text-based, and must be run out of the terminal/command prompt. There are, however, two systems of commands currently, a default "wordy" system (with commands such as "add guardian" and "show stack"), and a secondary "simple" system (with commands such as "g" and "ss"). There are also default values for the initial amiibo pool, and for stack size, but both of these have the ability to be changed while the program runs (but not saved).

# The Future
Ultimately the goal is to make this program accessible yet also as simple as it can be (from a user standpoint), so that the largest group of people could use it. Also, as this is extremely limited to BOTW, and more importantly to continuous and large amiibo use in that game (something that might happen in, say, a speedrun, but not much else), it must also be simple so that *potentially* it could be used by people streaming without any significant hinderence.

Other features, besides the simple simulation of the stack, could include tracking of amiibos uses (how many, what types, when), an undo feature, and maybe (speedrunning) split functionally in order to calculate basic stats on amiibo usage at different points in a given run.

In the future I plan to use this system as a foundation for an android app, so that one can easily use this while in the midst of playing (and streaming) BOTW without having to dedicate keboard/computer usage and without having to deal with an overly complicated system.

Time might also be put into setting up a web-based version that would allow multiple people (aka, viewers) to keep track of amiibo usage during play, but that's likely still quite far off.
