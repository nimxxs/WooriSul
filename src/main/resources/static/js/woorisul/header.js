/*  gnb-list(상위항목)
    마우스 올렸을 때 하위항목이 뜨고 사라지는 것 구현
 */
function showSubMenu(menuId) {
    const subMenu = document.getElementById(menuId);
    subMenu.style.display = 'block';
}

/*function hideSubMenu() {
    const subMenus = document.querySelectorAll('.snb-list');

    subMenus.forEach(function (subMenu) {
        subMenu.style.display = 'none';
    });
}*/

function hideSubMenu() {
    const subMenu1 = document.getElementById('snb-menu3');
    const subMenu2 = document.getElementById('snb-menu4');
    const subMenu3 = document.getElementById('snb-menu5');

    subMenu1.style.display = 'none';
    subMenu2.style.display = 'none';
    subMenu3.style.display = 'none';
}
