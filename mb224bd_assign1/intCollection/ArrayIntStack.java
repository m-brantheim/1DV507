package mb224bd_assign1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	@Override
	public void push(int n) {
		if(size >= values.length) {
			resize();
		}
		values[size] = n;
		size++;
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		int value = values[size - 1];
		size--;
		return value;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		return values[size - 1];
	}

}
