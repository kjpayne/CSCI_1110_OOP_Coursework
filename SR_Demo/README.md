# Silver Arrow Gameplay Demo

## Synopsis
This program here is a demo for a gameplay concept that I have. The idea is to emulate the movement of a first-person shooter in a top-down view.
In this demo, you are simple triangle so that you can see the rotation it easily. The rotation is done with the movement of the mouse, the triangle faces a circle that is 
moved by the mouse the whole time. Even when you move the triangle rotates to face it. You can also with the click of the mouse shoot an arrow that is represented by a silver line.
The arrow is shot to where the circle is as a way to aim. This is the basic gameplay I have so far and I plan to build on it in the future has I learn more.

## Motivation
What motivated me to make this is my game idea that I have. I want to in the future make the full game and I feel that it is a great start to it. I really wanted to see the concept 
in action so I finally put it into practice. I plan to add more it while I learn more so that it looks more like a demo and not just shapes. More will come.

## How to Play
You will need the classes CharacterPane and DemoRoom to run this demo, nothing else.

## Code Example
Here is some of the code that I used to make this demo. These first set is the code that moves the character.
```
public void setAllYUp() {
        setP1Y(getP1Y() > 0 ? getP1Y() - 10 : 0);
        setP2Y(getP2Y() > 60 ? getP2Y() - 10 : 60);
        setP3Y(getP3Y() > 60 ? getP3Y() - 10 : 60);
    }
public void setAllYDown() {
        setP1Y(getP1Y() < 940 ? getP1Y() + 10 : 940);
        setP2Y(getP2Y() < 1000 ? getP2Y() + 10 : 1000);
        setP3Y(getP3Y() < 1000 ? getP3Y() + 10 : 1000);
    }
public void setAllXLeft() {
        setP1X(getP1X() > 30 ? getP1X() - 10 : 30);
        setP2X(getP2X() > 0 ? getP2X() - 10 : 0);
        setP3X(getP3X() > 60 ? getP3X() - 10 : 60);
    }
public void setAllXRight() {
        setP1X(getP1X() < 1890 ? getP1X() + 10 : 1890);
        setP2X(getP2X() < 1860 ? getP2X() + 10 : 1860);
        setP3X(getP3X() < 1920 ? getP3X() + 10 : 1920);
    }
```
This one reads then a key is pressed to actually move the character
```
character.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    character.setAllYUp();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartY(character.getP1Y() + 30);
                    break;
                case S:
                    character.setAllYDown();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartY(character.getP1Y() + 30);
                    break;
                case A:
                    character.setAllXLeft();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartX(character.getP1X());
                    break;
                case D:
                    character.setAllXRight();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartX(character.getP1X());
                    break;
                default:
                    break;
            }
        });
```
And last but not less, this set of code rotates the character.
```
pane.setOnMouseMoved(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());
            character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
            pathLine.setEndX(circle.getCenterX());
            pathLine.setEndY(circle.getCenterY());
        });
```
```
public void rotateTriangle(double cX, double cY) {
        double distanceX = cX - getP1X();
        double distanceY = cY - getP1Y();
        double distanceTotal = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        double moveDistanceX = distanceX / distanceTotal;
        double moveDistanceY = distanceY / distanceTotal;
        double totalMove = Math.sqrt(moveDistanceX * moveDistanceX + moveDistanceY * moveDistanceY);
        double newMoveDX = moveDistanceX / totalMove;
        double newMoveDY = moveDistanceY / totalMove;
        double angle = Math.atan2(newMoveDY, newMoveDX);
        degrees = Math.toDegrees(angle) + 90;
        triangle.setRotate(degrees);
    }
```
## A Look At The Demo
[This is what it looks like!](SR_Snip_1.PNG)
[And this too!](SR_Snip_2.PNG)
