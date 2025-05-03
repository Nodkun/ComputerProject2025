
public class Player extends Entity
{
    Subpanel sp;
    KeyboardMovements key; //create an instance of the KeyboardMovements class
    public Player(Subpanel sp, KeyboardMovements key)
    {
        this.sp = sp; //set the subpanel
        this.key = key; //set the keyboard movements
    }
}