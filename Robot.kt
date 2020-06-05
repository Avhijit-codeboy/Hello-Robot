package googleProject
import java.util.*;
class Robot(var name:String?,var posX:Int,var posY:Int):move{

    init {
        println("Robot Initializing...")
        println("$name is ready to work")
    }
    override fun moveRight() = posX+1
    override fun moveLeft() = posX-1
    override fun moveUp() = posY-1
    override fun moveDown() = posY+1
}
interface move{
    fun moveRight():Int
    fun moveLeft():Int
    fun moveUp():Int
    fun moveDown():Int
}
fun main(args:Array<String>){
    val read = Scanner(System.`in`)
    println("Give the name of your robot")
    var askName = read.nextLine()
    println("Give the start position for $askName\nXpos and Ypos should be input with comma separator and no parenthesis like '0,0'")
    var startPos = read.nextLine()
    println("Give the instruction set.\nL-->Left\tR-->Right\tU-->Up\tD--Down")
    var positionX = Character.getNumericValue(startPos.get(0))
    var positionY = Character.getNumericValue(startPos.get(2))
    var inst = read.nextLine()
    val robo = Robot(askName,positionX,positionY)
    var length = inst.length-1
    for(i in 0..length) {
        when{
            inst.get(i)=='L'->positionX-=robo.moveLeft()
            inst.get(i)=='R'->positionX+=robo.moveRight()
            inst.get(i)=='U'->positionY-=robo.moveUp()
            inst.get(i)=='D'->positionY+=robo.moveDown()
        }
    }

    println("The robot $askName has moved to position ($positionX,$positionY) from position ($startPos)")
}
