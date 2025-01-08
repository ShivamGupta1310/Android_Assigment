How Configure Git
1. Create a Repository on GitHub
Go to GitHub and log in.
New repository.
Give your repository a name, description (optional), and choose visibility (Public or Private).
Click Create repository.
2. Initialize Git and Add Remote Repository in Android Studio
Open Your Project in Android Studio.
Enable Version Control:
Go to VCS in the top menu, then select Enable Version Control Integration.
Choose Git from the dropdown and click OK.
Add GitHub Remote URL:
Go to Git → Manage Remotes from the top menu.
Click the + button to add a new remote.
In the dialog, paste the GitHub repository URL you copied from GitHub (e.g., https://github.com/yourusername/your-repository.git).
Click OK to save the remote.
3. Ignore Unnecessary Files
Create/Modify .gitignore to Exclude Files:
Right-click on the root of your project and select New → File.
Name the file .gitignore if it doesn't already exist.
Add common files/folders to ignore, such as .idea/, build/, and other Android Studio-specific files:
lua
Copy code
.idea/
*.iml
build/
.gradle/
.DS_Store
local.properties


4. Add Project Files to VCS
Add Files to Git Version Control:
In the Project view, right-click on the files you want to add (or use the Ctrl + A to select all files).
Right-click and select Git → Add to add the files to version control.
5. Commit and Push to GitHub
Commit Your Changes:
Go to VCS → Commit or click Git in the side menu at the bottom.
Review the files to be committed.
Enter a commit message and click Commit (or Commit and Push if you want to push right away).
Push to GitHub:
After committing, go to VCS → Git → Push.
In the dialog that appears, make sure the correct remote (GitHub) is selected.
Click Push to upload your project to GitHub.



Format in Android Studio
- cmd + Alt + L

Find Value
- cmd + Shift + O

Up and down Line
- cmd + Shift 
Up Arrow and Down Arrow

Define Method , Color, String
- ALT + Enter
