# manulife-code-challenge
manulife code challenge
1. This App can run on Android OS from 2.2(Froyo) to 7.0(Nougat), and is compiled on Android OS 4.4.2(API 19).
2. I use keystore and proguard to package this App.
3. Design one widgets: TitleBar.java, use it into each activities except MainActivity, reduce duplicate code and easy to modify.
4. Use sharepreference to store a parameter to judge if enter MainActivity.
5. ListOfAccount shows all kinds of accounts and uses Gson to parse Json Data coming from folder assets through AsyncTask.
6. After parsing Json data, those data will be filled in Accounts.java and shows those data in a ListView through AccountsListAdapter.java. Each item of ListView is designed a widget which can be found in orderlist.xml.
7. Click any item from AccountsListAdapter will go to related Activity(ChequeAccHistory, SavingAccHistory, TFSAAccHistory).
8. ChequeAccHistory shows all history transactions under this account, and uses Gson to parse Json Data coming from folder assets through AsyncTask.
9. After parsing Json data, those data will be filled in AccTransactionHistory.java and Activity.java. then shows those data in a ListView through ChequingHistoryAdapter.java. Each item of ListView is designed a widget which can be found in historylist.xml.
10. TFSAAccHistory and SavingAccHistory have the same structure with ChequeAccHistory.
11. All Activities are in one folder, all adapters are in one folder, all datas are in one folder.
12. All constants are in Constant.java; all static functions are in Utils.java.

