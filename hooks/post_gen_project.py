#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil

project_dir = os.getcwd()

package_dir = '{{ cookiecutter.package_name }}'.replace('.', '/')

os.chdir(os.path.join("app","src","androidTest","java"))
os.makedirs(package_dir)
shutil.move('ApplicationTest.kt', package_dir + '/ApplicationTest.kt')

os.chdir(os.path.join(project_dir,"app","src","main","java"))
os.makedirs(package_dir)


os.chdir(os.path.join(project_dir,"app","src","test","java"))
os.makedirs(package_dir)
shutil.move('ExampleUnitTest.kt', package_dir + '/ExampleUnitTest.kt')

os.chdir(os.path.join(project_dir,"app","src","main","java",package_dir))
os.chdir(os.path.join(project_dir,"app","src","main","java"))

root_dst_dir = os.path.join(project_dir,"app","src","main","java",package_dir)
root_src_dir = os.path.join(project_dir,"app","src","main","java")

if '{{ cookiecutter.splash_screen }}' != 'y':
    shutil.rmtree('ui/splash')

if '{{ cookiecutter.retrofit }}' != 'y':
    os.remove('di/module/NetModule.kt')
    os.remove('utils/service/CallbackWrapper.kt')

base = os.path.join(root_src_dir,"core")
di = os.path.join(root_src_dir,"di")
utils = os.path.join(root_src_dir,"utils")
ui = os.path.join(root_src_dir,"ui")
db = os.path.join(root_src_dir,"db")

shutil.move('App.kt',os.path.join(project_dir,"app","src","main","java",package_dir,'App.kt'))

def moverecursively(source_folder, destination_folder):
    basename = os.path.basename(source_folder)
    dest_dir = os.path.join(destination_folder, basename)
    if not os.path.exists(dest_dir):
        shutil.move(source_folder, destination_folder)
    else:
        dst_path = os.path.join(destination_folder, basename)
        for root, dirs, files in os.walk(source_folder):
            for item in files:
                src_path = os.path.join(root, item)
                if os.path.exists(dst_file):
                    os.remove(dst_file)
                shutil.move(src_path, dst_path)
            for item in dirs:
                src_path = os.path.join(root, item)
                moverecursively(src_path, dst_path)

moverecursively(base,root_dst_dir)
moverecursively(di,root_dst_dir)
moverecursively(utils,root_dst_dir)
moverecursively(ui,root_dst_dir)
moverecursively(db,root_dst_dir)
