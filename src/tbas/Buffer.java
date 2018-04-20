package tbas;

import java.util.ArrayList;

public class Buffer {
	private ArrayList<Integer> dataBuffer;
	private int bufferPointer;

	public Buffer() {
		dataBuffer = new ArrayList<Integer>();
		dataBuffer.add(0);
		bufferPointer = 0;
	}


	public void clearBuffer() {
		dataBuffer.clear();
	}

	public void advanceBuffer() {
		bufferPointer += 1;
		if (dataBuffer.size() - 1 < bufferPointer) {
			dataBuffer.add(0);
		}
	}

	public void retreatBuffer() {
		bufferPointer -= 1;
	}

	public Integer readBuffer() {
		return dataBuffer.get(bufferPointer); 
	}

	public ArrayList<Integer> getBufferData() {
		return dataBuffer;
	}

	public void loadBuffer(ArrayList<Integer> tapeData) {
		this.dataBuffer = tapeData;
	}

	public int getBufferPointer() {
		return bufferPointer;
	}

	public void setBufferPointer(int dataPointer) {
		this.bufferPointer = dataPointer;
	}

	public void write(int input) {
		if(input < 255){
			dataBuffer.set(bufferPointer, input);
		}
	}

}
