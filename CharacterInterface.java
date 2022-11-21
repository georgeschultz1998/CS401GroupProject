public interface CharacterInterface {
    public String getName();
    public void setName(String nName);
    public int getHP();
    public void setHP(int nHP);
    public int getXPos();
    public int getYPos();
    public void setXPos(int nX);
    public void setYPos(int nY);

    //public Deck getDeck();

    @Override
    public String toString();
}
