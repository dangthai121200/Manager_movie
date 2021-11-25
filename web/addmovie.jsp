<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
    <head>
        <c:import url="include/header.jsp"/>
    </head>
    <body>
        <div
            class="flex h-screen bg-gray-50 dark:bg-gray-900"
            :class="{ 'overflow-hidden': isSideMenuOpen}"
            >
            <!-- Desktop sidebar -->
            <c:import url="include/navbarleft.jsp">
                <c:param value=' <span
                         class="absolute inset-y-0 left-0 w-1 bg-purple-600 rounded-tr-lg rounded-br-lg"
                         aria-hidden="true"
                         ></span>' name="addmovie"/>
            </c:import>
            <!-- Mobile sidebar -->
            <!-- Backdrop -->
            <div
                x-show="isSideMenuOpen"
                x-transition:enter="transition ease-in-out duration-150"
                x-transition:enter-start="opacity-0"
                x-transition:enter-end="opacity-100"
                x-transition:leave="transition ease-in-out duration-150"
                x-transition:leave-start="opacity-100"
                x-transition:leave-end="opacity-0"
                class="fixed inset-0 z-10 flex items-end bg-black bg-opacity-50 sm:items-center sm:justify-center"
                ></div>
            <div class="flex flex-col flex-1">
                <c:import url="include/navbartop.jsp"></c:import>
                    <main class="h-full pb-16 overflow-y-auto">
                        <div class="container px-6 mx-auto grid">
                            <h2
                                class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
                                >
                                Thêm phim
                            </h2>
                            <!-- CTA -->
                            <div
                                class="flex items-center justify-between p-4 mb-8 text-sm font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple"
                                href="https://github.com/estevanmaito/windmill-dashboard"
                                >
                                <div class="flex items-center">
                                    <svg
                                        class="w-5 h-5 mr-2"
                                        fill="currentColor"
                                        viewBox="0 0 20 20"
                                        >
                                    <path
                                        d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"
                                        ></path>
                                    </svg>
                                    <span>Hello admin</span>
                                </div>
                            </div>

                            <!-- General elements -->
                            <h4
                                class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300"
                                >
                                Thông tin phim
                            </h4>
                            <form action="ControllerSaveMovie" method="Post">
                                <div
                                    class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800"
                                    >
                                    <label class="block text-sm">
                                        <span class="text-gray-700 dark:text-gray-400">Tên phim</span>
                                        <input
                                            class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                                            placeholder="Tên phim"
                                            name="namemovie"
                                            />
                                    </label>

                                    <div class="mt-4 text-sm">
                                        <span class="text-gray-700 dark:text-gray-400">
                                            Loại phim
                                        </span>
                                        <div class="mt-2">
                                            <!--                    Lấy danh sách thể loại phim-->
                                        <c:forEach items="${filmTypes}" var="filmType">
                                            <c:import url="./include/RadioFilmType.jsp">
                                                <c:param value="${filmType.idFilmType}" name="idFilmType"/>
                                                <c:param value="${filmType.name}" name="nameFilmType"/>
                                            </c:import>
                                        </c:forEach>
                                    </div>
                                </div>

                                <div class="mt-4 text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">
                                        Thể loại
                                    </span>

                                    <div class="mt-2">
                                        <c:forEach items="${categorys}" var="category">
                                            <c:import url="./include/CheckBoxCategory.jsp">
                                                <c:param value="${category.idCategory}" name="idCategory"/>
                                                <c:param value="${category.name}" name="nameCategory"/>
                                            </c:import>

                                        </c:forEach>
                                    </div>
                                </div>

                                <label class="block text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">Quốc gia</span>
                                    <input
                                        class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                                        placeholder="Việt Nam"
                                        name="country"
                                        />
                                </label>
                                <label class="block text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">Đạo diễn</span>
                                    <input
                                        class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                                        placeholder="tên"
                                        name="diretor"
                                        />
                                </label>
                                <label class="block text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">Thời gian</span>
                                    <input
                                        type="number"
                                        class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                                        placeholder="Nhập số phút"
                                        name="timemovie"
                                        />
                                </label>

                                <label class="block text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">Năm sản xuất</span>
                                    <input type="number"
                                           class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                                           placeholder="2021"
                                           name="yearofmanufacture"
                                           />
                                </label>

                                <label class="block mt-4 text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">
                                        Trạng thái
                                    </span>
                                    <select
                                        name="status"
                                        class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-select focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                                        >
                                        <option value="Đang cập nhật">Đang cập nhật</option>
                                        <option value="Đã hoàn thành">Đã hoàn thành</option>
                                    </select>
                                </label>


                                <label class="block mt-4 text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">Nội dung phim</span>
                                    <textarea
                                        class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-textarea focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                                        rows="3"
                                        placeholder="Nhập nội dung phim"
                                        name="content"
                                        ></textarea>
                                </label>

                                <label class="block text-sm">
                                    <span class="text-gray-700 dark:text-gray-400">Chọn ảnh</span>
                                    <input type="file" name="file" enctype="multipart/form-data" accept=".png,.JPEG"
                                           class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                                           placeholder="2021"
                                           />
                                </label>

                                <button  type="submit" class="flex items-center justify-between p-2 mb-5 text-sm font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple" style="margin-top: 20px">Thêm phim</button>
                            </div>              
                        </form>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
