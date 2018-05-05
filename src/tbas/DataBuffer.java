package tbas;

import java.util.ArrayList;

public class DataBuffer {
	private ArrayList<Byte> dataBuffer;
	private int bufferPointer;

	public DataBuffer() {
		dataBuffer = new ArrayList<Byte>();
	}

	public void clearBuffer() {
		dataBuffer.clear();
	}

	public ArrayList<Byte> getBufferData() {
		return dataBuffer;
	}

	public void loadBuffer(ArrayList<Byte> tapeData) {
		this.dataBuffer = tapeData;
	}

	public void loadBuffer(char[] tapeData) {
		this.dataBuffer.clear();
		for (int i = 0; i <= tapeData.length - 1; i++) {
			this.dataBuffer.add((byte) tapeData[i]);
		}
	}

	public void enqueue(Byte input) {
		if (input < 255) {
			dataBuffer.add(input);
		}
	}

	public Byte dequeue(boolean fifo) {
		Byte holdByte;
		int tBufferSize = dataBuffer.size();
		
		if (fifo) {
			holdByte = dataBuffer.get(0);
			dataBuffer.remove(0);
		} else {
			holdByte = dataBuffer.get(tBufferSize - 1);
			dataBuffer.remove(tBufferSize - 1);
		}

		return holdByte;
	}

}
