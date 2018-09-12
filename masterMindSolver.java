public static void main(String[] args){
  //pool = Yellow, Blue, Green, Red, Orange, Purple
  String[] secret = ("Yellow", "Blue", "Green", "Red");
  MasterMinder game  new MasterMinder(secret);
  String[] guess = ("Blue", "Blue", "Blue", "Blue");
  game.move(guess);
  String[] revealed = game.getInfo(i);
  guess = guessBot(guess, revealed);
}
