<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                         ></span>' name="listmovie"/>
            </c:import>
            <!-- Mobile sidebar -->
            <!-- Backdrop -->
            <div class="flex flex-col flex-1 w-full">
                <c:import url="include/navbartop.jsp"/>
                <main class="h-full pb-16 overflow-y-auto">
                    <div class="container grid px-6 mx-auto">
                        <h2
                            class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
                            >
                            Tables
                        </h2>
                        <!-- CTA -->
                        <div
                            class="flex items-center justify-between p-4 mb-8 text-sm font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple"

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
                        <h4
                            class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300"
                            >
                            Danh sách phim
                        </h4>
                        <div class="w-full overflow-hidden rounded-lg shadow-xs">
                            <div class="w-full overflow-x-auto">
                                <table class="w-full whitespace-no-wrap">
                                    <thead>
                                        <tr
                                            class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800"
                                            >
                                            <th class="px-4 py-3">Phim</th>
                                            <th class="px-4 py-3">Thể loại</th>
                                            <th class="px-4 py-3">Quốc gia</th>
                                            <th class="px-4 py-3">Trang thái</th>
                                            <th class="px-4 py-3">Ngày thêm</th>
                                            <th class="px-4 py-3">Tác vụ</th>
                                        </tr>
                                    </thead>
                                    <tbody
                                        class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800"
                                        >
                                        <!--hiển thị danh sách phim-->
                                        <c:forEach items="${movies}" var="movie">
                                            <c:import url="./include/ItemMovie.jsp">
                                                <c:param value="${movie.nameMovie}" name="nameMovie"/>
                                                <c:param value="${movie.filmtype}" name="filmtype"/>
                                                <c:param value="${movie.getStringCategoryMoives()}" name="categoryMoives"/>
                                                <c:param value="${movie.country}" name="country"/>
                                                <c:param value="${movie.statusMovie}" name="statusMovie"/>
                                                <c:param value="${movie.dateAdd}" name="dateAdd"/>
                                            </c:import>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <div
                                class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t dark:border-gray-700 bg-gray-50 sm:grid-cols-9 dark:text-gray-400 dark:bg-gray-800"
                                >
                                <span class="flex items-center col-span-3">
                                    Showing 21-30 of 100
                                </span>
                                <span class="col-span-2"></span>
                                <!-- Pagination -->
                                <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
                                    <nav aria-label="Table navigation">
                                        <ul class="inline-flex items-center">
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md rounded-l-lg focus:outline-none focus:shadow-outline-purple"
                                                    aria-label="Previous"
                                                    >
                                                    <svg
                                                        class="w-4 h-4 fill-current"
                                                        aria-hidden="true"
                                                        viewBox="0 0 20 20"
                                                        >
                                                    <path
                                                        d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                                                        clip-rule="evenodd"
                                                        fill-rule="evenodd"
                                                        ></path>
                                                    </svg>
                                                </button>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                                                    >
                                                    1
                                                </button>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                                                    >
                                                    2
                                                </button>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 text-white transition-colors duration-150 bg-purple-600 border border-r-0 border-purple-600 rounded-md focus:outline-none focus:shadow-outline-purple"
                                                    >
                                                    3
                                                </button>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                                                    >
                                                    4
                                                </button>
                                            </li>
                                            <li>
                                                <span class="px-3 py-1">...</span>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                                                    >
                                                    8
                                                </button>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                                                    >
                                                    9
                                                </button>
                                            </li>
                                            <li>
                                                <button
                                                    class="px-3 py-1 rounded-md rounded-r-lg focus:outline-none focus:shadow-outline-purple"
                                                    aria-label="Next"
                                                    >
                                                    <svg
                                                        class="w-4 h-4 fill-current"
                                                        aria-hidden="true"
                                                        viewBox="0 0 20 20"
                                                        >
                                                    <path
                                                        d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                                                        clip-rule="evenodd"
                                                        fill-rule="evenodd"
                                                        ></path>
                                                    </svg>
                                                </button>
                                            </li>
                                        </ul>
                                    </nav>
                                </span>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
