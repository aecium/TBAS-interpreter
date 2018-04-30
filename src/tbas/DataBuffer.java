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

	public void advanceBuffer() {
		bufferPointer += 1;
		if (dataBuffer.isEmpty() || dataBuffer.size() - 1 < bufferPointer) {
			dataBuffer.add((byte)0);
		}
	}

	public void retreatBuffer() {
		bufferPointer -= 1;
	}

	public Byte readBuffer() {
		return dataBuffer.get(bufferPointer); 
	}

	public ArrayList<Byte> getBufferData() {
		return dataBuffer;
	}

	public void loadBuffer(ArrayList<Byte> tapeData) {
		this.dataBuffer = tapeData;
	}

	public void loadBuffer(char[] tapeData) {
		this.dataBuffer.clear();
		for (int i =0; i <= tapeData.length - 1; i++){
			this.dataBuffer.add((byte)tapeData[i]);
		}
	}
	
	public int getBufferPointer() {
		return bufferPointer;
	}

	public void setBufferPointer(int dataPointer) {
		this.bufferPointer = dataPointer;
	}

	public void enqueue(Byte input) {
		if(input < 255){
			dataBuffer.set(bufferPointer, input);
			advanceBuffer();
		}
	}
	
	public Byte dequeue(boolean filo) {
		Byte holdByte;
		
		if (filo){
			holdByte = dataBuffer.get(0);
			dataBuffer.remove(0);
		} else {
			holdByte = dataBuffer.get(dataBuffer.size()-1);
			dataBuffer.remove(dataBuffer.size()-1);
		}
		
		return holdByte;
	}

}
