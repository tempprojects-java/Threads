package com.gmail.gak.artem;

import java.io.File;

public class FileWatcher implements Runnable {

	private File path;
	private String[] files;
	private boolean listInit = false;
	private String msg;

	public FileWatcher(File path) {
		super();
		this.path = path;
	}

	public FileWatcher() {
		super();
	}

	@Override
	public void run() {
		if (!listInit) {
			initFileList();
		}

		for (; true;) {
			if (isChanged()) {
				System.out.println(msg);
				initFileList();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.getStackTrace();
			}
		}
	}

	private void initFileList() {
		files = getFileList();
	}

	private String[] getFileList() {
		File[] files = path.listFiles();
		String[] buffer = new String[files.length];

		int counter = 0;
		for (int i = 0; i < files.length; ++i) {
			if (files[i].isFile()) {
				buffer[counter++] = files[i].getName();
			}
		}

		String[] result = new String[counter];
		System.arraycopy(buffer, 0, result, 0, counter);
		return result;
	}

	private boolean isChanged() {
		String[] buffer = getFileList();

		if (buffer.length > files.length) {
			msg = "notice > new file was created";
			return true;
		} else if (buffer.length < files.length) {
			msg = "notice > new file was rmoved";
			return true;
		}

		for (int i = 0; i < files.length; ++i) {
			if (!files[i].equals(buffer[i])) {
				msg = "notice > file was changed";
				return true;
			}
		}

		return false;
	}

	public boolean isListInit() {
		return listInit;
	}

	public void setListInit(boolean listInit) {
		this.listInit = listInit;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
