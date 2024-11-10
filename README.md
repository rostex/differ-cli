## Difference CLI
**Differ CLI** is a command-line utility for comparing text files providing a visual difference between them. It allows users to quickly see the differences between two versions of a file and can be used in various contexts, such as version control, backup comparison, and more.
### Status:
[![Actions Status](https://github.com/rostex/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/rostex/java-project-71/actions)
[![Java CI](https://github.com/rostex/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/rostex/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/a37d42bcea0a13c941f5/maintainability)](https://codeclimate.com/github/rostex/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a37d42bcea0a13c941f5/test_coverage)](https://codeclimate.com/github/rostex/java-project-71/test_coverage)

## Supported File Formats

**Differ CLI** supports the following file formats for comparison:

- **JSON Files (.json)** - JavaScript Object Notation (JSON) formatted files.
- **XML Files (.xml)** - Extensible Markup Language files.
- **YAML Files (.yaml, .yml)** - YAML (YAML Ain't Markup Language) formatted files.
  
Currently, the utility is designed to work with text-based formats. Binary files and non-text formats are not supported.

### Links to Other Sections:
- [Installation](#installation)
  - [For macOS and Ubuntu (Linux)](#for-macos-and-ubuntu-linux)
  - [For Windows](#for-windows)
- [Usage](#usage)
- [Uninstallation](#uninstallation)
  - [For macOS and Ubuntu (Linux)](#for-macos-and-ubuntu-linux)
  - [For Windows](#for-windows)

## Installation

### For **macOS** and **Ubuntu** (Linux)

To install **Differ CLI**, follow these steps:
1. **Download the Installer Script**:
   Download the installation script by running the following command in your terminal:

   ```bash
   curl -L https://github.com/rostex/differ-cli/releases/download/v1.0.0/install-getdiff.sh -o install-getdiff.sh
   ```
2. **Make the Script Executable**: Change the permissions of the script to make it executable:

   ```bash
   chmod +x install-getdiff.sh
   ```

3. **Run the Installation Script**: Execute the script to install the utility:

   ```bash
   ./install-getdiff.sh
   ```
   The script will:
   - Download the latest version of the getdiff.jar file.
   - Create a directory called ~/.getdiff in your home directory.
   - Place the JAR file inside this directory.
   - Create a command script to launch the utility using Java.
   - Add the installation directory to your PATH environment variable, so you can run the utility globally.
     
4. **Verify Installation**  
   To verify that the utility has been installed correctly, open a regular Command Prompt or PowerShell window and run the following command:

   ```bash
   getdiff --version
   ```

### For **Windows**

To install **Differ CLI**, follow these steps:
1. **Download the Installer Script**:
   1. To download it using the command line, open PowerShell and run the following command:

   ```powershell
   Invoke-WebRequest -Uri "https://github.com/rostex/differ-cli/releases/download/v1.0.0/install-getdiff.ps1" -OutFile "$env:USERPROFILE\Downloads\install-getdiff.ps1"
   ```
   2. Ensure that the file has been successfully downloaded and is located in your current directory (e.g., `C:\Users\Your_Name\Downloads`).
2. **Run the Installation Script**
   1. Open PowerShell as an Administrator. This is required to modify the PATH environment variable and make the utility globally available.
       To do this:
       - Search for PowerShell in the Start menu.
       - Right-click and choose Run as Administrator.
    2. In PowerShell, navigate to the folder where the `install-getdiff.ps1` script was saved. For example, if the file is in your Downloads folder, use the following command:
       ```powershell
       cd C:\Users\Your_Name\Downloads
       ```
    3. Now, execute the script:

       ```powershell
       .\install-getdiff.ps1
       ```
       The script will:
       - Download the getdiff.jar file to C:\Users\Your_Name\.getdiff.
       - Create an executable command file getdiff.cmd to launch the utility.
       - Add the installation directory to your PATH environment variable, allowing you to run the utility from anywhere in the command line.
    4. After the script finishes, a message will be displayed indicating that the installation is complete.
  
3. Verify Installation  
   To verify that the utility has been installed correctly, open a regular Command Prompt or PowerShell window and run the following command:

   ```powershell
   getdiff --version
   ```

## Usage

After installation, you can use Differ CLI directly from the terminal with the following command:

```
getdiff <file1> <file2>
```

### Example
To compare two Yaml files:

```bash
getdiff --format=plain file1.yaml file2.yaml
```

This will output the differences between the two files in the terminal.

For more information:

```
# Plain format
getdiff --format=plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# Stylish format
getdiff file1.json file2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```

## Uninstallation
### For **macOS** and **Ubuntu** (Linux)
If you wish to uninstall Differ CLI, follow these steps:
1. **Download the Uninstallation Script**: Download the uninstall script by running the following command in your terminal:

   ```bash
   curl -L https://github.com/rostex/differ-cli/releases/download/v1.0.0/uninstall-getdiff.sh -o uninstall-getdiff.sh
   ```
2. **Make the Script Executable**: Change the permissions of the script to make it executable

   ```bash
   chmod +x uninstall-getdiff.sh
   ```
3. **Run the Uninstallation Script**: Execute the script to uninstall the utility:

   ```bash
   ./uninstall-getdiff.sh
   ```
The script will:

- Remove the getdiff.jar file and command script.
- Delete the ~/.getdiff directory.
- Remove the installation directory from your PATH variable.

### For **Windows**
If you wish to uninstall Differ CLI, follow these steps:
1. **Download the Uninstallation Script**: Download the uninstallation script by running the following command in PowerShell:

```powershell
Invoke-WebRequest -Uri "https://github.com/rostex/differ-cli/releases/download/v1.0.0/uninstall-getdiff.ps1" -OutFile "$env:USERPROFILE\Downloads\uninstall-getdiff.ps1"
```
2. Run the script as Administrator, just like the installation:

   ```powershell
   .\uninstall-getdiff.ps1
   ```
The script will:
- Remove the getdiff.jar file and command script.
- Delete the ~/.getdiff directory.
- Remove the installation directory from your PATH variable.


<!--
### Demonstrarion:

Get differences from json and yaml files in stylish format:
[![asciicast](https://asciinema.org/a/LjrKKjkPsFNmcMc6GKhHEceTZ.svg)](https://asciinema.org/a/LjrKKjkPsFNmcMc6GKhHEceTZ)

Get differences from files in plain format:
[![asciicast](https://asciinema.org/a/d9URN0jdw0vFRL1BflgYRDVEe.svg)](https://asciinema.org/a/d9URN0jdw0vFRL1BflgYRDVEe)

Get differences from files in json format:
[![asciicast](https://asciinema.org/a/COO1q9RnqotXtwKpsQ6U8zSTP.svg)](https://asciinema.org/a/COO1q9RnqotXtwKpsQ6U8zSTP)
-->


