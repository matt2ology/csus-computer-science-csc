# Logic Wizard

## Vision

An app for quickly creating and testing circuit diagrams.

## Features

- Undo/Redo
- Unlimited Canvas Space
- Sub-circuits (Circuits in Circuits)
- Lots of pre-defined gates

## Members

- Mitchell LunBeck
- Matthew M.
- Changlong Li

# Design

### Interface

The app will start out with a blank diagram covering most of the screen
and a small sidebar on the left with all the available components listed vertically. 
On the bottom of the sidebar will be a save button and 3 save slot buttons labeled “A”, “B”, and “C”. 
A layout can be restored by tapping on a save slot button. 
Tapping on the save button and then on the save slot button will instead save the layout to that slot.

![The starting interface with a blank canvas](https://github.com/CSUS-CSC-131-Fall-2019/Logic-Wizard/blob/master/readme_images/Starting%20Interface.png)

### Components

Components can be added to the screen by dragging them from the sidebar. 
Components on the screen will be about the size of a fingertip. 
If a component is already on the screen it can be moved by first touching 
and holding the screen without moving the finger and then dragging. 
Removing a component can be done by dragging a component back into the sidebar. 
While the component is being dragged, it will increase in size slightly and become transparent; 
The name of the component will also appear at the bottom of the screen. 
The first design document assumed components would be able to be placed 
free-form and allow overlapping. This approach failed to consider situations 
where the components could be completely overlapping. 
Instead, the components will be situated on a grid. 
If a component is dragged from the sidebar and it overlaps with an existing component, 
it will not be added. If the component is dragged from elsewhere on the screen 
and overlaps, it will snap back to its previous position. 
Each component will take up one tile of the grid. 

The implemented components will consist of AND, OR, and NOT gates, an LED for visualizing output, 
and a switch with a togglable output. A Switch can be toggled by tapping it.

![An AND Gate is being dragged onto the screen](https://github.com/CSUS-CSC-131-Fall-2019/Logic-Wizard/blob/master/readme_images/Component%20being%20dragged%20onto%20screen.png)

### Wires 

Wires will be created (and removed) between components by quickly dragging away
from the component without pressing and holding first. 
The wire will be completed if the drag ends while hovering over a component. 
One output can lead to multiple inputs. A wire cannot be connected to a component 
if doing so would create a loop in the component tree. 
The component that the wire will connect to when the finger is lifted will 
have its bounds highlighted. Wires can be removed by drawing a wire to the
component meant to be disconnected. 

Wires will render using taxicab routing without concern for existing wires. 
Preventing wires from overlapping will be managed by the user by the location they place the component. 
Any vertical change in-between the input and output pins will be bridged 
by the wire routing vertically about halfway in-between the components. 

Because all the binary components (AND, OR) have the communitive property, 
which input a wire is connected to is not important to the simulation. 
A wire will always connect to the top input if it is the only input attached. 
If a wire is connected to the bottom input, and the top one is detached, 
the bottom input will migrate to the top input. This implicitly allows for 
the inputs to be reordered, by removing and then reconnecting the top input. 
Not allowing selection to individual inputs allows components to be smaller on screen. 

![A collage of images showing how wires are connected](https://github.com/CSUS-CSC-131-Fall-2019/Logic-Wizard/blob/master/readme_images/Editing%20Wires.png)

(Wire routing image is obsolete)

![An image showing how wires are connected between components](https://github.com/CSUS-CSC-131-Fall-2019/Logic-Wizard/blob/master/readme_images/Wire%20routing.png) 

### Simulation

The simulation is considered always active, but because there are no clocks, 
the diagram will only need to be recomputed when a change is made. Wires 
that are on will render a different color than wires that are off. 

![Shows examples of the differences between on and off wires](https://github.com/CSUS-CSC-131-Fall-2019/Logic-Wizard/blob/master/readme_images/Simulation.png)
 