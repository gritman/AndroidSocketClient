package com.bianfeng.tongtian;

public abstract class CmdBase {
	protected String mAction = null;
	protected String mProcess = null;
	protected String mProcessAction = null;

	protected SrsPackage mSendSrsPkg = new SrsPackage();
	protected SrsPackage mRecvSrsPkg = new SrsPackage();

	public static CmdBase factory(String protId) {
		if (protId == ProtDef.CMDT_PLAYERCONNECT
				|| protId == ProtDef.CMDT_REQPROCESSAPP
				|| protId == ProtDef.CMDT_REQEAUTH
				|| protId == ProtDef.CMDT_PTPUSHMSG
				|| protId == ProtDef.CMDT_PLAYERDATA
				|| protId == ProtDef.CMDT_REQPLAYERPLUSDATA
				|| protId == ProtDef.CMDT_REQEAUTH) {
			return new CmdLogin();
		} else {
			return null;
		}
	}

	public void parse(String id, SrsPackage pkg) {
		String[] idArray = id.split(ProtDef.PROCESS_CUT);
		if (idArray.length == 1) {
			mAction = idArray[0];
		} else if (idArray.length == 2) {
			mProcess = idArray[0];
			mAction = idArray[1];
			mProcessAction = mProcess + ProtDef.PROCESS_CUT
					+ mAction;
		}
		if (pkg != null) {
			this.mRecvSrsPkg = pkg;
			resultHandler(new SrsStreamReader(
					mRecvSrsPkg.data.array()));
		}
	}

	public void resultHandler(SrsStreamReader streamReader) {

	}

	public void sendHandler(SrsStreamWriter streamWriter) {

	}
}
