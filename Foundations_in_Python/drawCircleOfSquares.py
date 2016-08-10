import turtle

def draw():
    
    window = turtle.Screen()
    window.bgcolor("black")

    t = turtle.Turtle()
    t.shape("turtle")
    t.color("white")
    t.speed(15)
 
    r = turtle.Turtle()
    r.shape("turtle")
    r.color("red")
    r.speed(15)

    k = turtle.Turtle()
    k.shape("turtle")
    k.color("white")
    k.speed(15)

    for i in range(0,18):
        for i in range(0,4):
            k.forward(260)
            k.left(90)
        k.right(20)

    for i in range(0,24):
        for i in range(0,4):
            r.forward(160)
            r.left(90)
        r.right(15)

    for i in range(0,36):
        for i in range(0,4):
            t.forward(80)
            t.left(90)
        t.right(10)

    window.exitonclick()

draw()
