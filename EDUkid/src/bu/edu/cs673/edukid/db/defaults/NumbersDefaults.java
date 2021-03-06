package bu.edu.cs673.edukid.db.defaults;

import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.model.Word;

public class NumbersDefaults {

	protected static String[] DEFAULT_NUMBERS = new String[] { "0", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "10" };

	private static Word[] ZERO_WORDS = new Word[] { new Word("Zero",
			R.drawable.zeroimage) };

	private static Word[] ONE_WORDS = new Word[] {
			new Word("One", R.drawable.onepng),
			new Word("One", R.drawable.countballone) };

	private static Word[] TWO_WORDS = new Word[] {
			new Word("Two", R.drawable.twopng),
			new Word("Two", R.drawable.countballtwo) };

	private static Word[] THREE_WORDS = new Word[] {
			new Word("Three", R.drawable.threepng),
			new Word("Three", R.drawable.threeballs) };

	private static Word[] FOUR_WORDS = new Word[] {
			new Word("Four", R.drawable.fourpng),
			new Word("Four", R.drawable.fourballs) };

	private static Word[] FIVE_WORDS = new Word[] {
			new Word("Five", R.drawable.fivepng),
			new Word("Five", R.drawable.fiveflowers),
			new Word("Two", R.drawable.countballfive) };

	private static Word[] SIX_WORDS = new Word[] {
			new Word("Six", R.drawable.sixpng),
			new Word("Six", R.drawable.countballsix) };

	private static Word[] SEVEN_WORDS = new Word[] {
			new Word("Seven", R.drawable.sevenpng),
			new Word("Seven", R.drawable.countballseven) };

	private static Word[] EIGHT_WORDS = new Word[] {
			new Word("Eight", R.drawable.eightpng),
			new Word("Eight", R.drawable.countballeight) };

	private static Word[] NINE_WORDS = new Word[] {
			new Word("Nine", R.drawable.ninepng),
			new Word("Nine", R.drawable.countballnine) };

	private static Word[] TEN_WORDS = new Word[] {
			new Word("Ten", R.drawable.tenpng),
			new Word("Ten", R.drawable.countballten) };

	protected static Word[][] NUMBER_WORDS = new Word[][] { ZERO_WORDS,
			ONE_WORDS, TWO_WORDS, THREE_WORDS, FOUR_WORDS, FIVE_WORDS,
			SIX_WORDS, SEVEN_WORDS, EIGHT_WORDS, NINE_WORDS, TEN_WORDS };
}
