package extra;



public class Traversing
{	


	public static void searchAndDeleteDirectory(final StringBuffer rootDirectory,final StringBuffer folderToBeDeleted)
	{ 
		try
		{
			java.util.List<java.io.File> directoryList=new java.util.ArrayList<java.io.File>();

			java.util.ArrayDeque<java.io.File> directoryStack = new java.util. ArrayDeque<java.io.File>();
			java.io.File node=new java.io.File(new String(rootDirectory));
			directoryStack.push(node);

			int filesDeleted=0;
			int directoriesDeleted=0;
			while(!directoryStack.isEmpty())
			{



				java.io.File file =directoryStack.pop();
				/*
				 * 
				 */
				System.out.println("Showing content of "+file.getAbsolutePath());
				if(file.getName().equalsIgnoreCase(new String(folderToBeDeleted)))
				{
					directoryList.add(file);
				}
				java.io.File[] files = file.listFiles();

				for(java.io.File f: files)
				{

					//if(f.isHidden()) continue;

					if(f.isDirectory())
					{
						directoryStack.push(f);
						continue;
					}
					else if(f.isFile())
					{
						System.out.println(f.getAbsolutePath());
						int lastPositionOfDot=f.getName().lastIndexOf(".");
				
						if(f.getName().substring(0,lastPositionOfDot).equalsIgnoreCase(new String(folderToBeDeleted)))
						{
							directoryList.add(f);
						}
					}



				}

			}


			for(java.io.File dir:directoryList)
			{/*

				System.out.println("Going to delete "+dir.getAbsolutePath());
				if(dir.isFile())
				{
					dir.delete();filesDeleted++;
				}
				else if(dir.isDirectory())
				{
					java.util.LinkedList<java.io.File> dirs = new java.util.LinkedList<java.io.File>();
					dirs.push(dir);
					while (dirs.peek() != null) 
					{

						dir = dirs.pop();

						java.io.File[] contents = dir.listFiles();

						if (contents.length == 0) 
						{

							dir.delete();
							directoriesDeleted++;

						} 
						else 
						{

							dirs.push(dir);

							for(java.io.File content : contents) 
							{

								if (content.isDirectory()) 
								{
									dirs.push(content);
								} 
								else
								{

									content.delete();filesDeleted++;

								}
							}


						}
					}
				}



			*/}
			System.out.println("Number of files deleted "+filesDeleted);
			System.out.println("Number of directories deleted "+directoriesDeleted);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}


	}
	public static void main(String argv[])
	{
		//new Traversing().displayDirectory());
		searchAndDeleteDirectory(new StringBuffer("C:\\Users\\DUTTA\\desktop\\UIM"),new StringBuffer("misc"));
	}
}
