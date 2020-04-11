Description = "A basic recipe for Hello world program"

LICENSE = "CLOSED"

SRC_URI = "file://hello.c \
"

S = "${WORKDIR}"

do_compile(){
	cd ${S}
	${CC} hello.c -o hello
}

do_install(){
	install -d ${D}/usr/bin
	install -m 777 ${S}/hello ${D}/usr/bin
}

INSANE_SKIP = "ldflags"

PACKAGES = "hello-bin"	


FILES_hello-bin = " /usr/bin/*"


