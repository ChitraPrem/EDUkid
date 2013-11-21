package bu.edu.cs673.edukid.db.model.category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Shape;
import bu.edu.cs673.edukid.db.model.Word;

@SuppressWarnings("serial")
public class ShapesCategory implements CategoryType {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoryName() {
		return "Shapes";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.shapesnew);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getItems() {
		// TODO: don't hardcode
		return DatabaseDefaults.getShapes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItem(int itemIndex) {
		// TODO
		return DatabaseDefaults.getShapes()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		return DatabaseDefaults.getShapes().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemPhoneticSound(int itemIndex) {
		// TODO
		Shape shape = Database.getInstance().getShapes().get(itemIndex);

		if (shape != null) {
			String ShapeSound = shape.getShapeSound();

			if (ShapeSound != null && !ShapeSound.isEmpty()) {
				return ShapeSound;
			}
		}

		return DatabaseDefaults.getDefaultShapePhoneticSounds()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex).length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemDrawableId(int itemIndex, int imageIndex) {
		// TODO
		return DatabaseDefaults.getDefaultShapeWords(itemIndex)[imageIndex]
				.getDrawableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, Word word) {
		// TODO: Jasjot, implement this
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editItemWord(int itemIndex, int wordIndex, Word word) {
		// TODO: Jasjot, implement this
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemTextSize() {
		return 50;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canAddItems() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canModifyCategory() {
		return false;
	}
}
