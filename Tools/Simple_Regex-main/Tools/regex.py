import re

# Regex pattern to replacement mapping
replacements = {
    r'WebUI\.click\((.+?)\)': r'UE.safeClick(\1)',
    r'WebUI\.doubleClick\((.+?)\)': r'UE.doubleClick(\1)',
    r'WebUI\.setText\((.+?)\)': r'UE.sendKeys(\1)',
    r'WebUI\.delay\((\d+)\)': lambda m: f'UE.pause({int(m.group(1)) * 1000})',
    r'WebUI\.waitForElementVisible\((.+?)\)': r'UE.waitForElementVisible(\1)',
    r'WebUI\.dragAndDropToObject\((.+?)\)': r'UE.dragAndDrop(\1)',
    r'WebUI\.dragAndDropByOffset\((.+?)\)': r'UE.dragAndDropByOffset(\1)',
    r'WebUI\.rightClick\((.+?)\)': r'UE.rightClickWithJS(\1)',

    r'WebUI\.back\(\)': r'UN.backPage()',
    r'WebUI\.refresh\(\)': r'UN.refreshPage()',
    r'WebUI\.switchToWindowIndex\((.+?)\)': r'UN.switchToWindowByIndex(\1)',
    r'WebUI\.closeWindow\(\)': r'UN.closeCurrentTab()',
    r'WebUI\.forward\(.*?\)': r'UN.forwardPage()',
    r'WebUI\.switchToWindowTitle\((.+?)\)': r'UN.switchToWindowByTitle(\1)',
    r'WebUI\.closeWindowIndex\((.+?)\)': r'UN.closeTabByIndex(\1)',

    r'WebUI\.acceptAlert\(\)': r'UA.acceptAlert()',
    r'WebUI\.dismissAlert\(\)': r'UA.dismissAlert()',
    r'WebUI\.getAlertText\(\)': r'UA.getAlertText()',
    r'WebUI\.setAlertText\((.+?)\)': r'UA.sendKeysToAlert(\1)',

    r'WebUI\.switchToFrame\(null,\s*(.+?)\)': r'UF.switchToFrameByIndex(\1)',
    r'WebUI\.switchToFrame\((.+?)\)': r'UF.switchToFrameByTestObject(\1)',
    r'WebUI\.switchToDefaultContent\(\)': r'UF.switchToDefaultContent()',
    r'WebUI\.switchToParentFrame\(\)': r'UF.switchToParentFrame()',

    r'WebUI\.selectOptionByValue\((.+?),\s*(.+?),\s*false\)': r'UD.selectDropDownByValue(\1, \2)',
    r'WebUI\.selectOptionByLabel\((.+?),\s*(.+?),\s*false\)': r'UD.selectDropDownByText(\1, \2)',
    r'WebUI\.selectOptionByIndex\((.+?),\s*(.+?)\)': r'UD.selectDropDownByIndex(\1, \2)',

    r'WebUI\.getText\((.+?)\)': r'UE.getElementText(\1)',
    r'WebUI\.verifyElementText\((.+?),\s*(.+?)\)': r'UV.assertEqualsString(\2, UE.getElementText(\1))',
    r'WebUI\.verifyEqual\((.+?),\s*(.+?)\)': r'UV.assertEqualsString(\1, \2)',
    r'WebUI\.verifyAllLinksOnCurrentPageAccessible\(.+?\)': r'UV.validateLinksAndImages()',
    r'WebUI\.verifyImagePresent\((.+?)\)': r'UV.validateAllImages(\1)',
    r'WebUI\.verifyLinksOnPageAccessible\((.+?)\)': r'UV.validateAllLinks(\1)',
    r'WebUI\.verifyLinksAccessible\((.+?)\)': r'UV.validateLinksFromList(\1)'
}

# Mapping prefixes to imports
imports = {
    'UE.': 'import utils.UtilityElement as UE',
    'UN.': 'import utils.UtilityNavigation as UN',
    'UA.': 'import utils.UtilityAlert as UA',
    'UF.': 'import utils.UtilityFrame as UF',
    'UV.': 'import utils.UtilityValidation as UV',
    'UD.': 'import utils.UtilityDropdown as UD',
    'findTestObject': 'import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject',
    'OR.': 'import com.kms.katalon.core.testobject.ObjectRepository as OR',
    'FailureHandling': 'import com.kms.katalon.core.model.FailureHandling'
}

# Collect used imports and logs
used_imports = set()
change_logs = []
output_lines = []

# Files
input_file = 'input.txt'
output_file = 'output.txt'

with open(input_file, 'r', encoding='utf-8') as file:
    lines = file.readlines()

for line_num, line in enumerate(lines, 1):
    replaced = line
    for pattern, replacement in replacements.items():
        if re.search(pattern, replaced):
            if callable(replacement):
                new_line = re.sub(pattern, replacement, replaced)
            else:
                new_line = re.sub(pattern, replacement, replaced)
            change_logs.append(f"[Line {line_num}] Pattern: {pattern} ➔ {new_line.strip()}")
            replaced = new_line
    output_lines.append(replaced)

    for prefix, import_stmt in imports.items():
        if prefix in replaced:
            used_imports.add(import_stmt)

# Write output with imports + logs
with open(output_file, 'w', encoding='utf-8') as file:
    for imp in sorted(used_imports):
        file.write(imp + '\n')
    file.write('\n')
    file.writelines(output_lines)
    file.write('\n// === Conversion Logs ===\n')
    for log in change_logs:
        file.write(log + '\n')

