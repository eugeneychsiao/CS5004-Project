CS 5004
Assignment 6
Yu-chun(Eugene) Hsiao, Zhenning Yu

This project is an animation editor that allows users to create multiple simple shapes. Shapes can be moved, scaled, or have their colors changed.

Building off of assignment 7, we first made changes to the view string. Rather than creating a new JFramePanel at every time tick, we
changed the code to update the current JFramePanel. This removed the overlapping panels that was previously displayed.

New Implementations:
Controller: The controller defines what each button does. It works with what is given to it by the ButtonJFrameView, and 
adjusts the timer accordingly.

ButtonJFrameView: The ButtonJFrameView provides details about the specifics of the buttons. It also contains all functionality of
the original JFrameView class.