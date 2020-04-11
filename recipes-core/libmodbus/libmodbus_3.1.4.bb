DESCRIPTION = "yocto recipe for libmodbus"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://README.md;md5=38dea4913309d29062ac8c13628a8c88"
SRC_URI += "git://github.com/stephane/libmodbus.git"
SRCREV = "f9358460ee1f62bcac716ad0444b3bbe7628b204"
S = "${WORKDIR}/git"

do_configure(){
        cd ${S}
        ./autogen.sh
        ./configure ac_cv_func_malloc_0_nonnull=yes --host=arm-linux-gnueabi

}

do_compile(){

        make
}
do_install(){

#install -d ${D}/usr/bin
install -d ${D}/usr/lib
install -m 777 ${S}/src/.libs/libmodbus.so  ${D}/usr/lib/
cd ${D}/usr/lib
mv libmodbus.so libmodbus.so.1
ln -sf linmodbus.so.1 libmodbus.so
}

#PACKAGES += "libmodbus-libs"
#FILES_${PN}-libs += "/usr/lib/libmodbus*.so"
INSANE_SKIP = "installed-vs-shipped"
