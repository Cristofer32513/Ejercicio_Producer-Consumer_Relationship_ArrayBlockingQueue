// Fig. 23.14: BlockingBuffer.java
// Creating a synchronized buffer using an ArrayBlockingQueue.

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
	
	private final ArrayBlockingQueue<Integer> buffer; // shared buffer
	
	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(1);
	}

	// place value into buffer
	public void blockingPut(int value) throws InterruptedException {
		buffer.put(value); // place value in buffer
		System.out.printf("%s%2d\t%s%d%n", "Productor escribe      ", value,
				"Celdas del buffer ocupadas: ", buffer.size());
	}

	// return value from buffer
	public int blockingGet() throws InterruptedException {
		int readValue = buffer.take(); // remove value from buffer
		System.out.printf("%s %2d\t%s%d%n", "Consumidor lee        ",
				readValue, "Celdas del buffer ocupadas: ", buffer.size());

		return readValue;
	}
} // end class BlockingBuffer