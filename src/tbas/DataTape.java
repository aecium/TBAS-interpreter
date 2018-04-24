package tbas;

import java.util.ArrayList;

public class DataTape {
	private ArrayList<Byte> dataTape;
	private int dataPointer;

	public DataTape() {
		dataTape = new ArrayList<Byte>();
		dataTape.add((byte) 0);
		dataPointer = 0;
	}

	public void incrementCellData() {
		if (dataTape.get(dataPointer) < 255) {
			dataTape.set(dataPointer,(byte) (dataTape.get(dataPointer) + 1));
		}
	}

	public void decrementCellData() {
		if (dataTape.get(dataPointer) > 0) {
			dataTape.set(dataPointer, (byte) (dataTape.get(dataPointer) - 1));
		}
	}

	public void clearTape() {
		dataTape.clear();
	}

	public void advanceTape() {
		dataPointer += 1;
		if (dataTape.size() - 1 < dataPointer) {
			dataTape.add((byte)0);
		}
	}

	public void retreatTape() {
		dataPointer -= 1;
	}

	public void jumpTape(int offset) {
		dataPointer += offset;
	}

	public Byte readTape() {
		return dataTape.get(dataPointer);
	}

	public ArrayList<Byte> getTapeData() {
		return dataTape;
	}

	public void setTapeData(ArrayList<Byte> tapeData) {
		this.dataTape = tapeData;
	}

	public int getDataPointer() {
		return dataPointer;
	}

	public void setDataPointer(int dataPointer) {
		this.dataPointer = dataPointer;
	}

	public void write(Byte input) {
		if (input < 255) {
			dataTape.set(dataPointer, input);
		}
	}

}
