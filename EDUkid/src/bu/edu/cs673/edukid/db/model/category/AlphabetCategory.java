package bu.edu.cs673.edukid.db.model.category;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseHelper;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.DefaultWordMapping;
import bu.edu.cs673.edukid.db.model.Letter;
import bu.edu.cs673.edukid.db.model.Word;

@SuppressWarnings("serial")
public class AlphabetCategory implements CategoryType {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoryName() {
		return "Alphabet";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCategoryId() {
		return Category.ALPHABET.ordinal();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.alphabet_selector);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(String item) {
		// NO-OP
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getItems() {

		return DatabaseDefaults.getAlphabet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItem(int itemIndex) {
		if (Database.getInstance().getLetters().size() != 0) {

			return Database.getInstance().getLetters().get(itemIndex)
					.getLetter();
		}
		return DatabaseDefaults.getAlphabet()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		if (Database.getInstance().getLetters().size() != 0) {

			return Database.getInstance().getLetters().size();
		}
		return DatabaseDefaults.getAlphabet().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemPhoneticSound(int itemIndex) {
		Letter letter = Database.getInstance().getLetters().get(itemIndex);

		if (letter != null) {
			String letterSound = letter.getLetterSound();

			if (letterSound != null && !letterSound.isEmpty()) {
				return letterSound;
			}
		}

		return DatabaseDefaults.getDefaultAlphabetPhoneticSounds()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDefaultWordCount(int itemIndex) {
		return DatabaseDefaults.getDefaultAlphabetWords()[itemIndex].length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getSettingsItemWords(int itemIndex) {
		Database database = Database.getInstance();
		List<DefaultWordMapping> defaultWordMappings = database
				.getDefaultWordMapping(DatabaseHelper
						.generateDefaultMappingSelection(getCategoryId(),
								itemIndex));

		List<Word> wordList = new ArrayList<Word>();
		Word[] defaultWords = DatabaseDefaults.getDefaultAlphabetWords()[itemIndex];

		for (int i = 0; i < defaultWords.length; i++) {
			Word defaultWord = defaultWords[i];
			defaultWord.setChecked(defaultWordMappings.get(i).isChecked());
			wordList.add(defaultWord);
		}

		List<Word> databaseWords = database.getWords(DatabaseHelper
				.generateWordsSelection(itemIndex));

		if (databaseWords.size() > 0) {
			for (Word databaseWord : databaseWords) {
				wordList.add(databaseWord);
			}
		}

		return wordList.toArray(new Word[0]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getSettingsItemWord(int itemIndex, int wordIndex) {
		return getSettingsItemWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getLearnItemWords(int itemIndex) {
		List<Word> learnWords = new ArrayList<Word>();

		for (Word settingsItemWord : getSettingsItemWords(itemIndex)) {
			if (settingsItemWord.isChecked()) {
				learnWords.add(settingsItemWord);
			}
		}

		return learnWords.toArray(new Word[0]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getLearnItemWord(int itemIndex, int wordIndex) {
		return getLearnItemWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLearnItemWordCount(int itemIndex) {
		return getLearnItemWords(itemIndex).length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, Word word) {
		Database.getInstance().addWord(itemIndex, word);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editItemWord(int itemIndex, int wordIndex, Word word) {
		Database.getInstance().updateWord(itemIndex, wordIndex, word);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteItemWord(int itemIndex, int wordIndex) {
		Database.getInstance().deleteWord(itemIndex, wordIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSettingsItemDrawableId(int itemIndex, int imageIndex) {
		List<Integer> drawableList = new ArrayList<Integer>();

		for (Word defaultWord : getSettingsItemWords(itemIndex)) {
			drawableList.add(defaultWord.getDrawableId());
		}

		return drawableList.get(imageIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getSettingsItemDrawable(int itemIndex, int imageIndex) {
		List<Drawable> drawableList = new ArrayList<Drawable>();

		List<Word> databaseWords = Database.getInstance().getWords(
				DatabaseHelper.generateWordsSelection(itemIndex));

		if (databaseWords.size() > 0) {
			for (Word databaseWord : databaseWords) {
				drawableList.add(databaseWord.getWordDrawable());
			}
		}

		int defaultWordCount = DatabaseDefaults.getDefaultAlphabetWords()[itemIndex].length;

		return drawableList.get(imageIndex - defaultWordCount);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLearnItemDrawableId(int itemIndex, int imageIndex) {
		return getLearnItemWords(itemIndex)[imageIndex].getDrawableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getLearnItemDrawable(int itemIndex, int imageIndex) {
		return getLearnItemWords(itemIndex)[imageIndex].getWordDrawable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemTextSize() {
		return 128;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canAddItems() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasGameMode() {
		return true;
	}
}
