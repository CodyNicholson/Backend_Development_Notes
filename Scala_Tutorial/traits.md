# Traits

A **Trait** is more like a Java Interface in that a class can extend more than one

However, unlike Java Interfaces, Traits can provide concrete methods and fields

```
object ScalaTutorial
{
    def main(args: Array[String])
    {
        val superman = new Superhero("Superman")
        println(superman.fly)
        println(superman.hitByBullet)
        println(superman.ricochet(2500))
    }

    trait Flyable
    {
        def fly : String
    }

    trait BulletProof
    {
        def hitByBullet : String

        def ricochet(startSpeed : Double) : String = {
            "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * 0.75)
        }
    }

    class Superhero(val name: String) extends Flyable with BulletProof{
        def fly = "%s flys through the air".format)this.name)
    }

    def hitByBullet = "The bullet bounces off of %s".format(this.name)
}
