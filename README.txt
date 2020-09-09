**************************************************************README************************************************************************************************************
********************************************************MAGS 3.0 Framework************************************************************************************************

Desktop Execution :
1. In Properties file "platform" should be set to desktop
2. To set the number of browser instances - In pom.xml set value under dataproviderthreadcount as desired number. 
   Note: (i) When pushing the code back to repo, the value should be set back to '8'
	 (ii) Irrespective of the instances set, for example if u have a tag, that has only 2 scenarios to it, 
              only 2 instances will open even if the value set is '8'.
3. Run the Parallel01IT runner file to initiate the execution
4. Please use 'non-static' methods for future scenario addition (static methods don't go well for parallel execution)
   Note: Whatever System Team has followed currently, please follow the same for future code changes/ Scenario addition


Mobile Execution :
1. In Properties file "platform" should be set to mobile
2. Mobile execution should be run on a single instance only. Multi-threading is not supported in Mobile for now. 
   In pom.xml set value under dataproviderthreadcount as '1'.
3. Run the Parallel01IT runner file to initiate the execution